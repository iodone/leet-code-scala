

class Solution:
    
    def isPalindrome(self, x):
        xx = x < 0 and -x or x
        tmp_xx = xx
        p_xx = 0

        while xx > 0:
            p_xx = p_xx * 10 + xx % 10
            xx = xx / 10

        return p_xx == tmp_xx


def main():
    s = Solution()
    test = -1234554321
    print s.isPalindrome(test)
    

if __name__ == '__main__':
       main() 
