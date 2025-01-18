class Solution {
public:
    int n,m;
    int delrow[4]={-1,0,1,0};
    int delcol[4]={0,1,0,-1};
    bool valid(int x,int y)
    {
        return (x>=0 && x<n && y>=0 && y<m);
    }
    int minCost(vector<vector<int>>& grid) {
        n=grid.size();
        m=grid[0].size();

        vector<vector<int>>dist(n,vector<int>(m,1e9));
    
        priority_queue<pair<int,pair<int,int>>,vector<pair<int,pair<int,int>>>,greater<pair<int,pair<int,int>>>>pq;
        pq.push({0,{0,0}});
        dist[0][0]=0;
        while(!pq.empty())
        {
            auto it = pq.top();
            int dis = it.first;
            int row = it.second.first;
            int col = it.second.second;
            pq.pop();

            if(row==n-1 && col==m-1)
            {
                
                return dis;
            }

            for(int i=0;i<4;++i)
            {
                int nrow = row+delrow[i];
                int ncol = col+delcol[i];

                if(valid(nrow,ncol))
                {
                    // we have to move right
                    if(grid[row][col] == 1)
                    {
                        if(col+1==ncol) 
                        {
                            if(dist[nrow][ncol]>dis+0)
                            {
                                dist[nrow][ncol] = dis;
                                pq.push({dis,{nrow,ncol}});
                            }
                        }
                        else if(dist[nrow][ncol]>dis+1)
                        {
                            dist[nrow][ncol]=dis+1;
                            pq.push({dis+1,{nrow,ncol}});
                        }
                    }
                    // we have to move left
                    else if(grid[row][col] == 2)
                    {
                        if(col-1 == ncol)
                        {
                            if(dist[nrow][ncol]>dis+0)
                            {
                                dist[nrow][ncol]=dis;
                                pq.push({dis,{nrow,ncol}});
                            }
                        }
                        else if(dist[nrow][ncol]>dis+1)
                        {
                            dist[nrow][ncol]=dis+1;
                            pq.push({dis+1,{nrow,ncol}});
                        }
                    }
                    else if(grid[row][col] == 3)
                    {
                        if(row+1 == nrow)
                        {
                            if(dist[nrow][ncol]>dis+0)
                            {
                                dist[nrow][ncol]=dis;
                                pq.push({dis,{nrow,ncol}});
                            }
                        }
                        else if(dist[nrow][ncol]>dis+1)
                        {
                            dist[nrow][ncol]=dis+1;
                            pq.push({dis+1,{nrow,ncol}});
                        }
                    }
                    else if(grid[row][col] == 4)
                    {
                        if(row-1 == nrow)
                        {
                            if(dist[nrow][ncol]>dis+0)
                            {
                                dist[nrow][ncol]=dis;
                                pq.push({dis,{nrow,ncol}});
                            }
                        }
                        else if(dist[nrow][ncol]>dis+1)
                        {
                            dist[nrow][ncol]=dis+1;
                            pq.push({dis+1,{nrow,ncol}});
                        }
                    }
                }
            }
        }
        return -1;
    }
};