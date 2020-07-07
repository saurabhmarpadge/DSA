package algorithms.search;
/*
  Implement:
    -Binary search (on sorted array of integers)
    -Binary search using recursion
    -Ceil of a number
    -Floor of a number
    -First Occurrence
    -Last Occurrence
  Advance Binary Search
    -Binary search Template 2
    -Binary search Template 3
*/

class BinarySearch {

    public static void main(String[] args) {
        int[] array = {-5,-3,-1,0,1,3,4,5,8,10,15};
        System.out.println(binarySearchIterative(array,5));
        System.out.println(binarySearchIterative(array,50));
        System.out.println(binarySearchRec(array,5,0,array.length-1));
        System.out.println(binarySearchRec(array,50,0,array.length-1));
        System.out.println(floorOfNumber(array,9));
        System.out.println(ceilOfNumber(array,9));
        array = new int[]{-5, -3, -1, 0, 1, 3, 3, 3, 3, 3, 4, 5, 8, 10, 15};
        System.out.println(firstOccIdx(array,3));
        System.out.println(lastOccIdx(array,3));
        System.out.println(binarySearchItrTwoEle(array,5));
        System.out.println(binarySearchItrTwoEle(array,50));
        System.out.println(binarySearchItrThreeEle(array,5));
        System.out.println(binarySearchItrThreeEle(array,50));
    }

    public static int binarySearchRec(int[] array, int low, int high, int target){
        if(low>high){
            return -1;
        }
        int mid = low + ((high-low)>>1);
        if(array[mid]==target){
            return mid;
        } else if(array[mid]>target){
            return binarySearchRec(array,low,mid-1,target);
        }

        return binarySearchRec(array,mid+1,high,target);
    }

    public static int binarySearchIterative(int[] array,int target){
        int low = 0;
        int high = array.length-1;
        while(low<=high){
            int mid = low + ((high - low)>>1);
            if(array[mid]==target){
                return mid;
            } else if(array[mid]>target){
                high = mid-1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static int binarySearchItrTwoEle(int[] array, int target){
        int left = 0;
        int right=array.length;
        while(left<right){
            int mid = left + (right-left)/2;
            if(array[mid]==target){
                return mid;
            } else if(array[mid]<target){
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if(left!=array.length&&array[left]==target){
            return left;
        }
        return -1;
    }

    public static int binarySearchItrThreeEle(int[] array, int target){
        int left = 0;
        int right=array.length-1;
        while(left+1<right){
            int mid = left + (right-left)/2;
            if(array[mid]==target){
                return mid;
            } else if(array[mid]<target){
                left = mid;
            } else {
                right = mid;
            }
        }
        if(array[left]==target){
            return left;
        }
        if(array[right]==target){
            return right;
        }
        return -1;
    }

    public static int floorOfNumber(int[] array,int target){
        int ans = -1;
        int low = 0;
        int high = array.length-1;
        while(low<=high){
            int mid = low + ((high-low)>>1);
            if(array[mid]<=target){
                ans = array[mid];
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    public static int ceilOfNumber(int[] array,int target){
        int ans = -1;
        int low = 0;
        int high = array.length-1;
        while(low<=high){
            int mid = low + ((high-low)>>1);
            if(array[mid]>=target){
                ans = array[mid];
                high = mid -1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }


    public static int firstOccIdx(int[] array, int target){
        int ans = -1;
        int left = 0;
        int right = array.length-1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(array[mid]==target){
                ans = mid;
                right = mid-1;
            } else if(array[mid]<target){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    public static int lastOccIdx(int[] array, int target){
        int ans = -1;
        int left = 0;
        int right = array.length-1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(array[mid]==target){
                ans = mid;
                left = mid +1;
            } else if(array[mid]<target){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
}