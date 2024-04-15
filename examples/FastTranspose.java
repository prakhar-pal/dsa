// implementation of fast transpose from horowitz-sahni-freed

class MatrixTriple {
  public int row, col, value;
  public MatrixTriple(int row, int col, int value) {
    this.row = row;
    this.col = col;
    this.value = value;
  }
  // @override
  public String toString() {
    return "Mat["+this.row+"]["+this.col+"]="+this.value;
  }
}

class SparseMatrix {

  public int rows, cols, total;
  public MatrixTriple data[];
  
  public SparseMatrix(int rows, int cols, MatrixTriple data[]) {
    this.rows = rows;
    this.cols = cols;
    this.total = data.length;
    this.data = data;
  }
  
  /*
  * Returns the transposes of the instance matrix
  * @method fastTranspose
  * @returns SparseMatrix
  */
  public SparseMatrix fastTranspose() {
    int newRows = this.cols;
    int newCols = this.rows;
    return this;
  }
}

class FastTransposeTester {  
  public static boolean areSameSparseMatrix(SparseMatrix a, SparseMatrix b) {
    if(a == null || b == null || a.rows != b.rows || a.cols != b.cols || a.total != b.total) return false;
    for(int i=0;i<a.total;i++){
      MatrixTriple mtA = a.data[i];
      MatrixTriple mtB = b.data[i];
      System.out.println("index="+i+",mtA:"+mtA+",mtB:"+mtB);     
      if(mtA.row != mtB.row || mtA.col != mtB.col || mtA.value != mtB.value){
        return false;
      }
    }
    return true;
  }
  
  public static void main(String[] args) {
    MatrixTriple[] triples = new MatrixTriple[1];
    triples[0] = new MatrixTriple(0,1,1);
    SparseMatrix mat = new SparseMatrix(2,2, triples);
    
    // expected result
    MatrixTriple[] expTriples = new MatrixTriple[1];
    expTriples[0] = new MatrixTriple(1,0,1);
    SparseMatrix expMat = new SparseMatrix(2,2, expTriples);
    assert !areSameSparseMatrix(mat, null);
    assert areSameSparseMatrix(mat, mat);
    assert areSameSparseMatrix(mat.fastTranspose(), expMat);
  }
}
