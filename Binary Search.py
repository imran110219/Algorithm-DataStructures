def binarySearch(arr, lower, upper, x):
  if upper >= 1:
    mid = (lower + upper)//2
    
    if arr[mid] == x:
      return mid
    elif arr[mid] > x:
      return binarySearch(arr, lower, mid-1, x)
    else:
      return binarySearch(arr, mid+1, upper, x)
    
    return -1
  
arr = [2, 4, 6, 8, 10, 12, 14, 16, 18, 20]
value = 10
result = binarySearch(arr, 0, len(arr)-1, value)

if result != -1:
  print(result)
else:
  print("Number Not Exist!")