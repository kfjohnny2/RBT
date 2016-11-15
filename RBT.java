package rbt;

public class RBT {

	private Node root;
	private RBT leftTree;
	private RBT rightTree;
	private RBT father;
	
// GETTERS AND SETTERS
	
	public Node getRoot() {
		return root;
	}

	public RBT getLeftTree() {
		return leftTree;
	}

	public RBT getRightTree() {
		return rightTree;
	}

	public RBT getFather() {
		return father;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	public void setLeftTree(RBT leftTree) {
		this.leftTree = leftTree;
	}

	public void setRightTree(RBT rightTree) {
		this.rightTree = rightTree;
	}

	public void setFather(RBT father) {
		this.father = father;
	}

// FUNCTIONS	
	
	public void percursoEmOrdem(){
		if (root == null) return;
		
		if (leftTree != null) leftTree.percursoEmOrdem();
		System.out.printf(root.getKey()+" ");
		if (rightTree != null) rightTree.percursoEmOrdem();
	}
	
	public void percursoPreOrdem(){
		if (root == null) return;
		
		System.out.printf(root.getKey()+" ");
		if (leftTree != null) leftTree.percursoPreOrdem();
		if (rightTree != null) rightTree.percursoPreOrdem();
	}
	
	public void percursoPosOrdem(){
		if (root == null) return;
		
		if (leftTree != null) leftTree.percursoPosOrdem();
		if (rightTree != null) rightTree.percursoPosOrdem();
		System.out.printf(root.getKey()+" ");
	}
	
	public RBT searchKey(int key) {
		if (root.getKey() == key)
			return this;
		else if (key > root.getKey())
			return rightTree.searchKey(key);
		else
			return leftTree.searchKey(key);
	}
	
	public void insert(int key, char color){
		root = new Node(key, color);
		root.setLeft(root.getRight());
		root.setRight(root.getParent);
		root.setParent(null);

		Node aux = root;
		Node aux2 = null;

		while(aux!=null){
			aux2.setNode(aux);
			if(root.getKey() < aux.getKey()){
				aux.setNode(aux.getLeft());
			} else if (root.getKey() > aux.getKey()){
				aux.setNode(aux.getRight());
			} else{
				aux.setKey(key);
				root.setNode(aux);
				return;
			}
		}
        if (root.getKey() <  aux2.getKey()){
            aux2.setLeft(root);
        }
        else{
            aux2.setRight(root);
        }

        root.setParent(aux2);
	}
	
	public void remove(int key){
		
	}
	
	// b is the right child of a
	public void rotateLeft(RBT a, RBT b) {
		a.rightTree = b.leftTree;
		b.leftTree = a;
	}
	
	// b is the left child of a
	public void rotateRight(RBT a, RBT b) {
		a.leftTree = b.rightTree;
		b.rightTree = a;
	}

}

