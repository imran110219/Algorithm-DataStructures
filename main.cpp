#include<cstdio>	//to use the printf function
#include<conio.h>         		//to use the getche function
#include<cstdlib>         		//to use the rand function
#include<cmath>

typedef struct Chrom             		// creating the chrom structure
{
    short int position_1[6];
    short int position_2[6];
    double fit;
} chrom;                           	// now we have a chrom type that we can use

void *evpop(chrom popcurrent[4]);    	//defining the functions that we will use
int x(chrom popcurrent);
double y(int x);
void *pickchroms(chrom popcurrent[4]);
void *crossover(chrom popnext[4]);
void *mutation(chrom popnext[4]);

int main()								// the main function
{
    short int start[6] = {0,0,0,0,0,0};         // start point (0, 0)
    short int goal[6] = {1,1,1,1,1,1};          // end point (7, 7)
    vector< vector<data> > Map;

    int num;								// num is the no. of iterations
    int i,j;

    printf("\nWelcome to the Genetic Algorithm coded by Loay Al Lusi:http://www.linkedin.com/in/loayallusi in May 2005 \nThe Algorithm is based on the function y = -x^2 + 5 to find the maximum value of the function...\n"); // introduction to the program


enter:
    printf("\nPlease enter the no. of iterations:  ");
    scanf("%d",&num);             	// enter the no. of iterations in num

    chrom popcurrent[4];                        	// we make 4 chromes of popcurrent
    chrom popnext[4];                           	// we make 4 chromes of popnext

    if(num<1)                               	// if a -ve number is inserted .. enter num again
        goto enter;

    evpop(popcurrent);                       	//initialise pop current

    for(i=0; i<num; i++)                      	// loop num times
    {
        printf("\ni = %d\n",i);        	// print the iteration number

        for(j=0; j<4; j++)
            popnext[j]=popcurrent[j];            	//copy popcurrent to popnext in order to adjust it

        pickchroms(popnext);                    	//pick best chromes
        crossover(popnext);                      	//cross over to get children chromes
        mutation(popnext);                       	//mutate with a low probability

        for(j=0; j<4; j++)
            popcurrent[j]=popnext[j];             	//copy the chromes of popnext to popcurrent

    }                                           // loop back until no. of iterations is exceeded

    printf("\nPress any key to end ! ");

    //flushall();                             		// flush the input buffer
    //getche();                                	// wait for a character from the keyboard to end

}                                            	//end of main



void *evpop(chrom popcurrent[4])               	//takes a pointer to a chrom of 4 elements
{
    int i,j,value;
    int random;
    for(j=0; j<4; j++)                        // loop of j to choose chromes from [0] to [3]
    {
        for(i=0; i<6; i++)            			// loop of i to choose the gen of the chrom from  [0] to [5]

        {
            random=rand();               		// creating random value
            random=(random%2);        			// make the random value o or 1 only
            popcurrent[j].position_1[i]=random;  		// initialising the bit[i] of chrom[j] with random
            random=rand();               		// creating random value
            random=(random%2);        			// make the random value o or 1 only
            popcurrent[j].position_2[i]=random;  		// initialising the bit[i] of chrom[j] with random
        }   // end of for(i)

        value=x(popcurrent[j]);
        popcurrent[j].fit=y(x(popcurrent[j]));	// calcualte the fitness of chrom[j]
        printf("\n popcurrent[%d]=%d%d%d %d%d%d %d%d%d %d%d%d    value=%d    fitness = %lf",j,
               popcurrent[j].position_1[5], popcurrent[j].position_1[4], popcurrent[j].position_1[3],
               popcurrent[j].position_1[2], popcurrent[j].position_1[1], popcurrent[j].position_1[0],
               popcurrent[j].position_2[5], popcurrent[j].position_2[4], popcurrent[j].position_2[3],
               popcurrent[j].position_2[2], popcurrent[j].position_2[1], popcurrent[j].position_2[0],
               value, popcurrent[j].fit);     // print the chrom[j]

    }    // end of for(j)


    return(0);
}                              	//end of evpop function

int x(chrom popcurrent)        	//x function that evaluate the value of a given chrom
{
    int x1, y1, x2, y2;
    x1 = (popcurrent.position_1[3]*1)+(popcurrent.position_1[4]*2)+(popcurrent.position_1[5]*4);
    y1 = (popcurrent.position_1[0]*1)+(popcurrent.position_1[1]*2)+(popcurrent.position_1[2]*4);
    x2 = (popcurrent.position_2[3]*1)+(popcurrent.position_2[4]*2)+(popcurrent.position_2[5]*4);
    y2 = (popcurrent.position_2[0]*1)+(popcurrent.position_2[1]*2)+(popcurrent.position_2[2]*4);
    int distancex = (x2 - x1)^2;
    int distancey = (y2 - y1)^2;                  	// z=sum of the ( bits * their weights) with the sign value
    int calcdistance = distancex + distancey;
    return calcdistance;                	//return the value of z
}                             	// end x function

double y(int x)          		// the y function that we look for it's maximum value takes x value
{          	// the function is y= - ( x^ 2 ) +5
    //int distancex = (x2 - x1)^2;
    //int distancey = (y2 - y1)^2;

    double calcdistance = sqrt(x);
    //calcdistance = 1.0/calcdistance;
    return (calcdistance);
}                             	// end of y function

void *pickchroms(chrom popcurrent[4])   	// pickchroms takes a pointer to array of chroms
{

    int i,j;
    chrom temp;                            	//temp chrome to use in sorting

    for(i=0; i<3; i++)               		//sorting the given set due to fitness
        for(j=0; j<3; j++)
        {
            if(popcurrent[j+1].fit>popcurrent[j].fit)
            {
                temp=popcurrent[j+1];
                popcurrent[j+1]=popcurrent[j];
                popcurrent[j]=temp;

            }   // end of if
        }                // end of for loop

    for(i=0; i<4; i++)
        printf("\nSorting:popnext[%d] fitness=%lf",i,popcurrent[i].fit);   	//printing the result
    printf("\n");                 //print new line
    //flushall();                                                       //flush the input buffer
    return(0);
}                       //end of pick chromes function

void *crossover(chrom popnext[4]) // crossover function takes a pointer to array of chromes
{
    int random;
    int i;
    random=rand();                                  	//random cross over point
    random=((random%5)+1);                    		// cross point should be between (1 - 5)
    for(i=0; i<random; i++)                     	//crossing the bits below the cross point index
    {
        popnext[2].position_1[i]=popnext[0].position_1[i];        	//child 1 cross over
        popnext[3].position_1[i]=popnext[1].position_1[i];     	// child 2 cross over

        popnext[2].position_2[i]=popnext[0].position_2[i];        	//child 1 cross over
        popnext[3].position_2[i]=popnext[1].position_2[i];
    } // end of for

    for(i=random; i<6; i++)                        	// crossing the bits beyond the cross point index
    {
        popnext[2].position_1[i]=popnext[1].position_1[i];     	// child 1 cross over
        popnext[3].position_1[i]=popnext[0].position_1[i];       	// chlid 2 cross over

        popnext[2].position_2[i]=popnext[1].position_2[i];     	// child 1 cross over
        popnext[3].position_2[i]=popnext[0].position_2[i];
    }    // end of for

    for(i=0; i<4; i++)
        popnext[i].fit=y(x(popnext[i]));     	// calculating the fitness values for the new set

    for(i=0; i<4; i++)
        printf("\nCrossOver popnext[%d]=%d%d%d %d%d%d %d%d%d %d%d%d    value=%d    fitness = %lf",i,
               popnext[i].position_1[5],popnext[i].position_1[4],popnext[i].position_1[3],popnext[i].position_1[2],popnext[i].position_1[1],popnext[i].position_1[0],
               popnext[i].position_2[5],popnext[i].position_2[4],popnext[i].position_2[3],popnext[i].position_2[2],popnext[i].position_2[1],popnext[i].position_2[0],
               x(popnext[i]),popnext[i].fit);
    // printing the bits, value and fitness for the chromes of the new set

    return(0);
}                  // end crossover function

void *mutation(chrom popnext[4])   // mutation funtion given a pointer to array of chromes
{

    int random;
    int row,col,value;
    random=rand()%50;                  //random value is between ( 0 - 49 )

    if (random==25)    // Suppusiong Probability of mutation is 2 %
    {
        col=rand()%6;                           	// random column (gene) choosing
        row=rand()%4;                           	// random row ( chrome ) choosing

        if (popnext[row].position_1[col]==0)          	// invert the bit to 1 if it was 0
            popnext[row].position_1[col]=1 ;

        else if (popnext[row].position_1[col]==1)       	// invert the bit to 0 if it was 1
            popnext[row].position_1[col]=0;

        if (popnext[row].position_2[col]==0)          	// invert the bit to 1 if it was 0
            popnext[row].position_2[col]=1 ;

        else if (popnext[row].position_2[col]==1)       	// invert the bit to 0 if it was 1
            popnext[row].position_2[col]=0;

        popnext[row].fit=y(x(popnext[row]));   	// calculate the fitness for the mutated chrome
        value=x(popnext[row]);
        printf("\nMutation occured in popnext[%d] bit[%d]:=%d%d%d %d%d%d %d%d%d %d%d%d    value=%d fitness=%lf",
               row,col,
               popnext[row].position_1[5],popnext[row].position_1[4],popnext[row].position_1[3], popnext[row].position_1[2],popnext[row].position_1[1],popnext[row].position_1[0],
               popnext[row].position_2[5],popnext[row].position_2[4],popnext[row].position_2[3], popnext[row].position_2[2],popnext[row].position_2[1],popnext[row].position_2[0],
               value,popnext[row].fit);

        // print the chrome index,bits,value, fintness of the mutated chrome
    }         	// end of if

    return(0);
}                       //end of mutation
