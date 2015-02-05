class Solution:
    # @return an integer
    def reverse(self, x):
        tag = (x > 0 and 1) or -1
        x = x * tag
        r = 0
        while x > 0:
            t = x % 10
            r = r * 10 + t
            x = x / 10

        return int(r) * tag

def main():

    s = Solution()
    r = s.reverse(1534236469)
    print r

if __name__ == "__main__":
    main()
