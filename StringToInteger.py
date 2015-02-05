class Solution:
    # @return an integer
    def is_numeric(self, c):
        return ord(c) >= ord('0') and ord(c) <= ord('9')

    def atoi(self, str):
        is_start = 1
        sign = 1
        n = 0
        int_max = (1 << 31) - 1
        int_min = - (1 << 31)
        for c in str:
            if not self.is_numeric(c):
                if is_start:
                    if c == ' ':
                        continue
                    is_start = 0
                    if c == '-':
                        sign = -1
                    elif c == '+':
                        sign = 1
                    else:
                        break;

                else:
                    break
            else:
                n = n * 10 + (ord(c) - ord('0'))
                is_start = 0
                print n
                if sign * n > int_max:
                    return int_max
                if sign * n < int_min:
                    return int_min
            

        return sign * n


                    
def main():

    s = Solution()
    r = s.atoi('1234567890123456789012345678901234567890')
    print r

if __name__ == "__main__":
    main()
