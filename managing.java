import java.util.Scanner;

class Hash_Table_banks {
    class nodes {
        String key;
        KD_tree value;
        Hash_Table_banks.nodes after;
    }
    public String string;
    public int h=0;
    public int n;
    public nodes[] tableOfnode;
    public Hash_Table_banks(int i) {
        tableOfnode = new nodes[i];
    }
    public void put(String k, KD_tree v) {
        int a=0;
        int x = hash(k);
        nodes array = tableOfnode[x];
        for (int i=0;array != null;i++) {
            if (!array.key.equals(k)){
                array = array.after;
                continue;
               }
            else
            break;
        }
        if (array == null) {
            double d=.75;
            if (n >=d*tableOfnode.length) {
                resize();
            }
            nodes j = new nodes();
            j.value = v;
            j.key = k;
            j.after = tableOfnode[x];
            tableOfnode[x] = j;
            n=n+1;
        }
        else {
            array.value = v;
        }
    }
    public int size() {
        int size=n;
        return size;
    }
    public KD_tree get(String s) {
        int a=0;
        int x = hash(s);
        nodes array = tableOfnode[x];
        for (int i=0;array != null;i++) {
            if (array.key.equals(s)){
                return array.value;}
            array = array.after;
            continue;
        }
        return null;
    }
    public int hash(String s) {
        int d=s.hashCode();
        int c=tableOfnode.length;
        return (Math.abs(d)) % c;
    }
    public void resize() {
        int a=tableOfnode.length;
        int b=tableOfnode.length*2;
        nodes[] jadid = new nodes[b];
        int j=0;
       while (j < a) {
            nodes array = tableOfnode[j];
            for (int z=0;array != null;z++) {
                nodes new_one = array.after;
                int c=jadid.length;
                int d=array.key.hashCode();
                int m = (Math.abs(d))%c;
                array.after = jadid[m];
                jadid[m] = array;
                array = new_one;
            }
            j++;
        }
        tableOfnode = jadid;
    }
}

class Hash_Table_mahale {
    class nodes {
        String key;
        neighbourhood value;
        Hash_Table_mahale.nodes after;
    }
    public String string;
    public int h=0;
    public int n;
    public nodes[] tableOfnode;
    public Hash_Table_mahale(int i) {
        tableOfnode = new nodes[i];
    }
    public void put(String k, neighbourhood ne) {
        int a=0;
        int x = hash(k);
        nodes array = tableOfnode[x];
        for (int i=0;array != null;i++) {
            if (!array.key.equals(k)){
                array = array.after;
                continue;
            }
            else
                break;
        }
        if (array == null) {
            double d=.75;
            if (n >=d*tableOfnode.length) {
                resize();
            }
            nodes j = new nodes();
            j.value = ne;
            j.key = k;
            j.after = tableOfnode[x];
            tableOfnode[x] = j;
            n=n+1;
        }
        else {
            array.value = ne;
        }
    }
    public int size() {
        int size=n;
        return size;
    }
    public neighbourhood get(String s) {
        int a=0;
        int x = hash(s);
        nodes array = tableOfnode[x];
        for (int i=0;array != null;i++) {
            if (array.key.equals(s)){
                return array.value;}
            array = array.after;
            continue;
        }
        return null;
    }
    public int hash(String s) {
        int d=s.hashCode();
        int c=tableOfnode.length;
        return (Math.abs(d)) % c;
    }
    public void resize() {
        int a=tableOfnode.length;
        int b=tableOfnode.length*2;
        nodes[] jadid = new nodes[b];
        int j=0;
        while (j < a) {
            nodes array = tableOfnode[j];
            for (int z=0;array != null;z++) {
                nodes new_one = array.after;
                int c=jadid.length;
                int d=array.key.hashCode();
                int m = (Math.abs(d))%c;
                array.after = jadid[m];
                jadid[m] = array;
                array = new_one;
            }
            j++;
        }
        tableOfnode = jadid;
    }
}

class node{
    node rast;
    node chap;
    bank value;
    public boolean equals(node a) {
            if(a.value.y==this.value.y&&a.value.x==this.value.x){
                return true;
            }
            else
                return false;
        }
}

class bank{
    int x;
    int y;
    String name;
    char position;
    boolean main=true;
    int numberOfBranches=0;
    node root;
    KD_tree shobeha;
    String nameOfBank;
}

class shobe extends bank {
    boolean main=false;
    String nameOfBank;
    String nameOfHere;

}


class  neighbourhood{
    String name;
    int x_min;
    int x_max;
    int y_max;
    int y_min;
    int [] Xs=new int[4];
    int [] Ys=new int[4];
}


 class KD_tree {
     int numberOfBanks;
     node root;
   public  void add(node b,node rishe,char co){
      if(root==null){
          b.value.position='x';
          root=b;
          numberOfBanks++;
          return;
      }
     else if(rishe.chap==null&&co=='x'&&rishe.value.x>b.value.x){
          b.value.position='x';
          rishe.chap=b;
          numberOfBanks++;
          return;
      }
     else if(rishe.rast==null&&co=='x'&&rishe.value.x<b.value.x){
          b.value.position='x';
          rishe.rast=b;
          numberOfBanks++;
          return;
      }
     else   if(rishe.chap==null&&co=='y'&&rishe.value.y>b.value.y){
           b.value.position='y';
           rishe.chap=b;
           numberOfBanks++;
           return;
       }
     else if(rishe.rast==null&&co=='y'&&rishe.value.y<b.value.y){
           b.value.position='y';
           rishe.rast=b;
           numberOfBanks++;
           return;
       }
      else {
          if(co=='x'){
              if(b.value.x>rishe.value.x){
                  add(b,rishe.rast,'y');
              }
              else if(b.value.x<rishe.value.x){
                   add(b,rishe.chap,'y');
              }
          }
          else if(co=='y'){
              if(b.value.y>rishe.value.y){
                  add(b,rishe.rast,'x');
              }
             else if(b.value.y<rishe.value.y){
                  add(b,rishe.chap,'x');
              }
          }
      }

   }
   public int size(){
        return numberOfBanks;
   }
   public  node cheking_nearest(node father,char farzand,node result,node a,char co){
       if(farzand=='r' && father.chap==null){
           return result;
       }
       if(farzand=='l' && father.rast==null){
           return result;
       }
       if (father==null){
           return result;
       }
      else {
         int x= (a.value.x-result.value.x)*(a.value.x-result.value.x);
         int y= (a.value.y-result.value.y)*(a.value.y-result.value.y);
         int d1=x+y;
         int d2=0;
         if (co=='x'){
             co='y';
          d2=(father.value.x-a.value.x)*(father.value.x-a.value.x);}
           if (co=='y'){
               co='x';
               d2=(father.value.y-a.value.y)*(father.value.y-a.value.y);}
         if(d2>d1){
             return result;
         }
         else {
             node n=new node();
             if (farzand=='l'){
                 n=father.rast;
             }
             if (farzand=='r'){
                 n=father.chap;
             }
           node c=nearest(a,n,co);
            result=compare_with_root(c,result,a);
            return result;
         }
       }
   }//n,root
   public node compare_with_root(node n1,node n2,node a){
       if (n1==null){
           return n2;
       }
       if (n2==null){
           return n1;
       }
       else {
           int d1=((n1.value.x-a.value.x)*(n1.value.x-a.value.x))+((n1.value.y-a.value.y)*(n1.value.y-a.value.y));
           int d2=((n2.value.x-a.value.x)*(n2.value.x-a.value.x))+((n2.value.y-a.value.y)*(n2.value.y-a.value.y));
           if (d1 < d2)
               return n1;
           else
               return n2;
       }
   }
   node father;
   char farzand;
   public  node nearest(node a,node rishe,char co) {
       if (rishe==null) {
           return null;
       }
      /* if ((rishe.chap == null && axis == 'x' && rishe.value.x >= a.value.x) || (rishe.chap == null && axis == 'y' && rishe.value.y >= a.value.y)) {
           return cheking_nearest(father,farzand,rishe,a);
       }
       if ((rishe.rast == null && axis == 'x' && rishe.value.x <= a.value.x) || (rishe.rast == null && axis == 'y' && rishe.value.y <= a.value.y)) {
           return cheking_nearest(father,farzand,rishe,a);
       }*/
       else {
           char c='x';
           father = rishe;
           node result=new node();
           if (co == 'x') {
               c='x';
               if (a.value.x >= rishe.value.x) {
                   farzand='r';
                   node g= nearest(a, rishe.rast, 'y');
                    result=compare_with_root(g,rishe,a);
               }
               if (a.value.x < rishe.value.x) {
                   farzand='l';
                   node g= nearest(a, rishe.chap, 'y');
                    result=compare_with_root(g,rishe,a);
               }
           }
           if (co == 'y') {
               c='y';
               if (a.value.y >= rishe.value.y) {
                   farzand='r';
                   node g= nearest(a, rishe.rast, 'x');
                    result=compare_with_root(g,rishe,a);
               }
               if (a.value.y < rishe.value.y) {
                   farzand='l';
                   node g= nearest(a, rishe.chap, 'x');
                    result=compare_with_root(g,rishe,a);
               }
           }
           result=cheking_nearest(father,farzand,result,a,c);
           return result;
       }
   }
   public   void reading(node rishe){
       if(rishe==null){
           System.out.println("EMPTY");
           return;
       }
       if(rishe.rast==null&&rishe.chap==null){
           String s=rishe.value.name;
           int x=rishe.value.x;
           int y=rishe.value.y;
           s="name: "+s+" x: "+x+" y: "+y;
           System.out.println(s);
           return;
       }
       if(rishe.rast==null&&rishe.chap!=null){
           String s=rishe.value.name;;
           int x=rishe.value.x;
           int y=rishe.value.y;
           s="name: "+s+" x: "+x+" y: "+y;
           System.out.println(s);
           reading(rishe.chap);
           return;
       }
       if(rishe.rast!=null&&rishe.chap==null){
           String s=rishe.value.name;
           int x=rishe.value.x;
           int y=rishe.value.y;
           s="name: "+s+" x: "+x+" y: "+y;
           System.out.println(s);
           reading(rishe.rast);
           return;
       }
       else {
           String s=rishe.value.name;
           int x=rishe.value.x;
           int y=rishe.value.y;
           s="name: "+s+" x: "+x+" y: "+y;
           System.out.println(s);
           reading(rishe.chap);
           reading(rishe.rast);
           return;
       }
   }
    boolean main=false;
    String name;
    String bankname;
     public boolean search_detail(node root ,int c,node a) {
         if (root == null)
             return false;
         c=c%2;
         if (root.value.x == a.value.x && root.value.y == a.value.y){
             main=root.value.main;
             name=root.value.name;
             bankname=root.value.nameOfBank;
             return true;
         }
         if ((c==0 && a.value.x < root.value.x) || (c==1 && a.value.y < root.value.y))
             return search_detail(root.chap,  c+1,a);
         else
             return search_detail(root.rast, c+1,a);
     }

     public  boolean search_general(node a) {
         return search_detail(root,0,a);
     }

     public  void deleting_structure(node a) {
         if ( root == null){
            System.out.println("EMPTY");
            return;}
         if(main==true){
            System.out.println("NOT BRANCH");
            return;
         }
         a.value.name=name;
        this.root = delete_details(root, 0, a);
         System.out.println("DELETING DONE");
     }
    public  node delete_details(node rishe, int co,node t) {
       // node n=null;
        co = co %2;
         if (rishe == null)
             return null;
         if (t.equals(rishe)) {
             if (rishe.rast != null) {
                 node kamtarin_rast = kamtarin( co, co+1,rishe.rast);
                 rishe.value.x = kamtarin_rast.value.x;
                 rishe.value.y = kamtarin_rast.value.y;
                 rishe.value.name=kamtarin_rast.value.name;
                 rishe.rast = delete_details(rishe.rast, co+1, kamtarin_rast);
             } else if (rishe.chap != null) {
                 node kamtarin_chap = kamtarin( co, co+ 1,rishe.chap);
                 rishe.value.x = kamtarin_chap.value.x;
                 rishe.value.y = kamtarin_chap.value.y;
                 rishe.value.name=kamtarin_chap.value.name;
                 rishe.rast = delete_details(rishe.chap,co+1, kamtarin_chap);
                 rishe.chap = null;
             } else {
                 return null;
             }
             if (co==1){
                 if ((rishe.rast != null && rishe.rast.value.y < rishe.value.y))
                    System.out.println("NOT OK");
                 if ((rishe.chap != null && rishe.chap.value.y >= rishe.value.y)){
                     System.out.println("NOT OK");
                 }
             }
             else if (co==0){
                 if ((rishe.chap != null && rishe.chap.value.x >= rishe.value.x ))
                    System.out.println("NOT OK");
                 if ( (rishe.rast != null && rishe.rast.value.x < rishe.value.x)){
                     System.out.println("NOT OK");
                 }
             }
             return rishe;
         }
         if (co==0&&t.value.x < rishe.value.x) {
             rishe.chap = delete_details(rishe.chap, co + 1,t);
         }
         if (co==1&&t.value.y < rishe.value.y) {
             rishe.chap = delete_details(rishe.chap, co + 1,t);
         }
         else {
             rishe.rast = delete_details(rishe.rast, co + 1,t);
         }
         return rishe;
     }

     public   node kamtarin( int td, int nd,node rishe) {
         if (rishe == null){
             return null;}
         int r=(nd+1)%2;
         if (td == nd) {
             if (rishe.chap == null){
                 return rishe;}
             return kamtarin(td,r,rishe.chap );
         }
         node kam_chap = kamtarin(td,  r,rishe.chap);
         node kam_rast = kamtarin(td,  r,rishe.rast);
        node a = rishe;
        if (kam_rast!=null){
         if (kam_rast.value.x <a.value.x&& td==0){
             a = kam_rast;}
         if (kam_rast.value.y < a.value.y&& td==1){
             a = kam_rast;}
         }
        if(kam_chap!=null){
         if (kam_chap.value.x < a.value.x&& td==0)
             a = kam_chap;
         if (kam_chap.value.y < a.value.y&& td==1)
             a = kam_chap;}
         return a;
     }
     String s="";
     public void banks_in_neighbor(neighbourhood n,node rishe,int xory){
         if(rishe==null){
             return ;
         }
         xory=xory%2;
         if ((xory == 0 && rishe.value.x <= n.x_min) || (xory == 1 && rishe.value.y <= n.y_min)) {
             banks_in_neighbor(n,rishe.rast,xory+1);
         }
         if ((xory == 0 && rishe.value.x >= n.x_max) || (xory == 1 && rishe.value.y >= n.y_max)) {
             banks_in_neighbor(n,rishe.chap,xory+1);
         }
         if(rishe.value.x<=n.x_max&&rishe.value.x>=n.x_min&&rishe.value.y<=n.y_max&&rishe.value.y>=n.y_min){
             System.out.print("bank: "+rishe.value.name+" ");
             banks_in_neighbor(n,rishe.chap,xory+1);
             banks_in_neighbor(n,rishe.rast,xory+1);
         }
         else {
             banks_in_neighbor(n,rishe.chap,xory+1);
             banks_in_neighbor(n,rishe.rast,xory+1);
         }

     }
     boolean cheking_r(int x_po,int y_po, double r, int x_c,int y_c) {
         int d = ((x_po - x_c)*(x_po-x_c));
         int c=((y_po-y_c) * (y_po -y_c));
         d=d+c;
         boolean result=false;
         if(d <= r*r){
             return true;
         }
          else
              return false;
     }
     public void finding_node_r_range(node rishe, int x_p,int y_p, double r, int c) {
         if (rishe == null)
             return ;
         c=c%2;
         int y_c=rishe.value.y;
         int x_c=rishe.value.x;
         boolean result=cheking_r(x_p, y_p, r, x_c, y_c);
         if (result) {
             System.out.println(rishe.value.name+" "+rishe.value.x+" "+rishe.value.y);
         }
         int t=c+1;
         if (c==0) {
             double a=x_p + r;
             double b=x_p - r;
             if (x_c  <a )
                 finding_node_r_range(rishe.rast, x_p,y_p, r, t);
             if (x_c >b )
                 finding_node_r_range(rishe.chap, x_p,y_p, r, t);
         } else {
             double a=y_p + r;
             double b=y_p - r;
             if (y_c < a)
                 finding_node_r_range(rishe.rast, x_p,y_p, r, t);
             if (y_c > b)
                 finding_node_r_range(rishe.chap, x_p,y_p, r, t);
         }
     }
 }


  public class managing{
    public static int[] find_min_max(int[] x,int[] y){
        int max1=0;
        for (int i = 0; i < 4; i++) {
            if(x[i]>max1){
                max1=x[i];
            }
        }
        int min1=max1;
        for (int i = 0; i < 4; i++) {
            if(x[i]<min1){
                min1=x[i];
            }
        }
        int max2=0;
        for (int i = 0; i < 4; i++) {
            if(y[i]>max2){
                max2=y[i];
            }
        }
        int min2=max2;
        for (int i = 0; i < 4; i++) {
            if(y[i]<min2){
                min2=y[i];
            }
        }
        int[] result=new int[4];
        result[0]=max1; result[2]=min1;
        result[1]=max2; result[3]=min2;
        return result;
    }
    public static void main(String[] args){
        KD_tree tree=new KD_tree();
        Hash_Table_banks banks=new Hash_Table_banks(1000);
        Hash_Table_mahale listOfNeighbor=new Hash_Table_mahale(1000);
        int  numberOfNeighbor=0;int numberofbanks=0;
        Scanner scanner=new Scanner(System.in);

        while (true){
            String input=scanner.next();
            if(input.equals("addN")){
                neighbourhood n=new neighbourhood();
                for (int i = 0; i <4 ; i++) {
                    int a=scanner.nextInt();
                    n.Xs[i]=a;
                    int b=scanner.nextInt();
                    n.Ys[i]=b;
                }
               String name=scanner.next();
                n.name=name;
                int[] a=find_min_max(n.Xs,n.Ys);
                n.x_max=a[0];
                n.y_max=a[1];
                n.x_min=a[2];
                n.y_min=a[3];
                if(numberOfNeighbor<1000){
                    listOfNeighbor.put(name,n);
                }
                else {
                    listOfNeighbor.resize();
                }
                numberOfNeighbor++;
                System.out.println("NEIGHBOR ADDED");
                continue;
            }
            if(input.equals("addB")){
                int a=scanner.nextInt();
                int b=scanner.nextInt();
                String name=scanner.next();
                bank bank=new bank();
                bank.name=name;
                bank.x=a;
                bank.y=b;
                node node=new node();
                node.value=bank;
                boolean isExist = tree.search_general(node);
                if (isExist == true){
                    System.out.println("we have already had this bank");
                    continue;}
                tree.add(node,tree.root,'x');
                banks.put(name,new KD_tree());
                numberofbanks++;
                if (numberofbanks>=1000){
                    banks.resize();
                }
                System.out.println("MAIN BANK ADDED");
                continue;
            }
            if(input.equals("addBr")){
                int a=scanner.nextInt();
                int b=scanner.nextInt();
                String name=scanner.next();
                String bankName=scanner.next();
               shobe sh=new shobe();
                bank ba=new bank();
                ba.nameOfBank=bankName;
                ba.name=name;
                ba.main=false;
                ba.x=a;
                ba.y=b;
                node node=new node();
                node.value=ba;
                boolean isExist = tree.search_general(node);
                if (isExist == true){
                    System.out.println("we have already had bank in this place");
                    continue;}
               banks.get(bankName).add(node,banks.get(bankName).root,'x');
                tree.add(node,tree.root,'x');
               System.out.println("BRANCH WAS ADDED");
               continue;
            }
            if(input.equals("nearB")){
                int a=scanner.nextInt();
                int b=scanner.nextInt();
                bank ba=new bank();
                ba.x=a;
                ba.y=b;
                node n=new node();
                n.value=ba;
                node result= tree.nearest(n,tree.root,'x');
                System.out.println("NEAREST BANK :");
                System.out.println("NAME: "+result.value.name+"  "+"x: "+result.value.x+"  "+"y: "+result.value.y);
                continue;
            }
            if(input.equals("nearBr")){
                int a=scanner.nextInt();
                int b=scanner.nextInt();
                String name=scanner.next();
                bank ba=new bank();
                ba.x=a;
                ba.y=b;
                node n=new node();
                n.value=ba;
                node rishe=banks.get(name).root;
                node result=banks.get(name).nearest(n,rishe,'x');
                System.out.println("NEAREST BranchBANK :");
                System.out.println("NAME: "+result.value.name+"  "+"x: "+result.value.x+"  "+"y: "+result.value.y);
                continue;
            }
             if(input.equals("listBrs")){
                 String name=scanner.next();
                 node rishe=banks.get(name).root;
                 banks.get(name).reading(rishe);
                 continue;
             }
            if(input.equals("delBr")) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                bank ba=new bank();
                ba.x=a;
                ba.y=b;
                node n=new node();
                n.value=ba;
                boolean isExist = tree.search_general(n);
                if (isExist == false){
                    System.out.println("NOT EXIST");
                     continue;}
                tree.deleting_structure(n);
                if (tree.bankname!=null){
                banks.get(tree.bankname).deleting_structure(n);}
                continue;
            }
            if(input.equals("listB")) {
                String name = scanner.next();
                neighbourhood n = listOfNeighbor.get(name);
               tree.banks_in_neighbor(n, tree.root, 0);
                 continue;
            }
            if(input.equals("availB")){
                int r=scanner.nextInt();
                int x=scanner.nextInt();
                int y=scanner.nextInt();
                tree.finding_node_r_range(tree.root,x,y,r,0);
                continue;
            }
        }
    }
}