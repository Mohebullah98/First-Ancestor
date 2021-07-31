class Main {
  public static treeNode FirstAncestor(treeNode x, treeNode y){
    if(x==null||y==null) return null;
    if(isParent(x,y)) return x;//check if x is a parent of y and vice vera
    if(isParent(y,x)) return y;
    return FirstAncestor(x.parent,y.parent);//recurse until one is parent of the other, using their parents
  }
  public static boolean isParent(treeNode x, treeNode y){
    if(x==null||y==null) return false;
    if(x==y)return true; //if x==y then x is an ancestor of y
    if(x.left==null&&x.right==null)return false;//you reached the bottom of x's lineage and y hasn't been seen
    if(!isParent(x.left,y)&&!isParent(x.right,y)) return false;//if both the left and right children of x aren't a parent of y. then x isn't an ancestor.
    return true;
  }
  public static void main(String[] args) {
    treeNode root = new treeNode(2);
    treeNode a = new treeNode(30);
    treeNode b = new treeNode(10);
    treeNode c = new treeNode(15);
    treeNode d = new treeNode(17);
    treeNode e = new treeNode(55);
    treeNode f = new treeNode(37);
    treeNode g = new treeNode(3);
    root.right=a;root.left=b; a.parent=root;//building the tree
    b.right=c;b.left=e; b.parent=root;
    c.right=d;c.parent=b; d.parent=c;
    e.parent =b;e.right=f;e.left=g;f.parent=e;g.parent=e;
    treeNode z = FirstAncestor(d,f);
    System.out.print(z.data);// should print 10 since the first ancestor of d and f is b
  }
}