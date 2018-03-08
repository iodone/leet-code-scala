class Solution:

    def print_prime(self, n):
        
        prime_index = [True] * n
        prime_index[0] = False
        prime_index[1] = False

        for i in range(2,n):
            if prime_index[i]:
               for j in range(i+i,n,i): 
                   prime_index[j] = False
        

        return [i for i in range(n) if prime_index[i] == True] 
        


def main():
    s = Solution()
    ret = s.print_prime(100)
    print ret

if __name__ == "__main__":
    main()
