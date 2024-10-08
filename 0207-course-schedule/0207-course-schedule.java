class Solution {
    class node{
        int val;
        node next;
        node(int val,node next){
            this.val=val;
            this.next=next;
        }
    }

    class graph{
        int vertices;
        node List[];
        graph(int vertices){
            List=new node[vertices];
            this.vertices=vertices;
        }
    }

    public int detectCycle(graph g,int start,int visited[],int path[]){
        if(visited[start]==1){
            if(path[start]==1)return 1;
            return 0;
        }

        visited[start]=1;
        path[start]=1;

        node temp=g.List[start];
        while(temp!=null){
            if(detectCycle(g,temp.val,visited,path)==1)return 1;
            temp=temp.next;
        }

        path[start]=0;
        return 0;
    }

    public boolean canFinish(int num, int[][] edges) {
        graph g=new graph(num);
        for(int i=0;i<edges.length;i++){
            if(g.List[edges[i][0]]==null)g.List[edges[i][0]]=new node(edges[i][1],null);
            else{
                node newnode=new node(edges[i][1],null);
                newnode.next=g.List[edges[i][0]];
                g.List[edges[i][0]]=newnode;
            }
        }

        int visited[]=new int [num];
        int path[]=new int [num];
        for(int i=0;i<num;i++){
            visited[i]=0;
            path[i]=0;
        }

        for(int i=0;i<num;i++){
            if(visited[i]==0){
                if(detectCycle(g,i,visited,path)==1)return false;
            }
        }
        return true;
    }
}