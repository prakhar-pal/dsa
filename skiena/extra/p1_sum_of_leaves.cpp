//https://www.geeksforgeeks.org/find-sum-left-leaves-given-binary-tree/
#include <iostream>
using namespace std;

struct Node{
    int value;
    struct Node* left, *right;
};

// struct Node 
// { 
//     int value; 
//     struct Node* left, *right; 
// };

Node* make_node(int value){
    Node* node = (Node*)malloc(sizeof(Node));
    node->value = value;
    node->right = node->left = NULL;
    return node;
}

void print_tree(Node *root){
    if(root == NULL) return;
    print_tree(root->left);
    cout<<root->value<<" ";
    print_tree(root->right);
}

void sol_util(Node* node, int& sum){
    if(node == NULL) return;
    if(node->left != NULL && node->left->left == NULL && node->left->right == NULL){
        sum += node->left->value;
    }
    sol_util(node->left, sum);
    sol_util(node->right, sum);
}

int sum_of_leaves(Node *root){
    int sum = 0;
    sol_util(root, sum);
    return sum;
}

int main(){
    Node* root = make_node(20);
    root->left = make_node(9);
    root->right = make_node(49);
    root->right->left= make_node(23);
    root->right->right =  make_node(52);
    root->right->right->left = make_node(50);
    root->left->left = make_node(5);
    root->left->right = make_node(12);
    root->left->right->right = make_node(12);
    // print_tree(root);
    cout<<sum_of_leaves(root)<<endl;
}
