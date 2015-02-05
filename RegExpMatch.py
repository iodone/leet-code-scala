
class Solution:
    # @return a tuple, (index1, index2)
    def twoSum(self, num, target):
        
        d = {} 
        for i in range(len(num)):
            d[num[i]] = i
        for i in range(len(num)):
            x = num[i]
            y = target - x
            if y in d and d[y] != i:
                index_x = i + 1
                index_y = d[y] + 1
                if index_x > index_y:
                    index_x, index_y = index_y, index_x
                return (index_x, index_y)
        return None


def main():
    test_num = [0, 3, 2, 4, 0]
    test_target = 0 
    s = Solution();
    ret = s.twoSum(test_num, test_target)
    print ret

if __name__ == "__main__":
    main()
