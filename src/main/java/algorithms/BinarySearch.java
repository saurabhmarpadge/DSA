package algorithms;
/*
Implement:
    -Binary search (on sorted array of integers)
    -Binary search using recursion
    -Ceil of a number
    -Floor of a number
*/

class BinarySearch {

    int binarySearchIterative(int[] array,int target){
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

    int binarySearchIterative(int[] array, int low, int high, int target){
        if(low>high){
            return -1;
        }
        int mid = low + ((high-low)>>1);
        if(array[mid]==target){
            return mid;
        } else if(array[mid]>target){
            return binarySearchIterative(array,low,mid-1,target);
        }

        return binarySearchIterative(array,mid+1,high,target);
    }

    int ceilOfNumber(int[] array,int target){
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

    int floorOfNumber(int[] array,int target){
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
}