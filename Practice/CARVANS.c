    #include<stdio.h>
    inline int inp()
        {
        int noRead=0;
        char p=getchar_unlocked();
        for(;p<33;){p=getchar_unlocked();};
        while(p>32)
        {
        noRead = (noRead << 3) + (noRead << 1) + (p - '0');
        p=getchar_unlocked();
        }
        return noRead;
        };
    int main()
    {
        int t,lim,maxs,cnt,n;
        //scanf("%d",&t);
        t=inp();
        while(t--)
        {
            //scanf("%d",&n);
            n=inp();
            maxs=inp();
            n--;
            lim=maxs;
            cnt=1;
            while(n--)
            {
                //scanf("%d",&maxs);
                maxs=inp();
                if(maxs<=lim)
                {
                    cnt++;
                    lim=maxs;
                }
            }
            printf("%d\n",cnt);
        }
        return 0;
    }  
