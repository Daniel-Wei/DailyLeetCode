class Solution:
    def numTeams(self, rating: List[int]) -> int:
        ans=0
        #[2,5,3,4,1]
        # 3 --> sol=1 , lol=1
        # 3 --> sor =1 , lor=1
        # asc=sol*lor
        # desc=sor*lol
        
        for i in range(len(rating)):
            sol=0;lol=0
            for j in range(i):
                if rating[j]<rating[i]:
                    sol+=1
                if rating[j]>rating[i]:
                    lol+=1
            sor=0;lor=0
            for j in range(i+1,len(rating)):
                if rating[j]<rating[i]:
                    sor+=1
                if rating[j]>rating[i]:
                    lor+=1
            a=sol*lor
            d=sor*lol
            ans+=a+d
        return ans