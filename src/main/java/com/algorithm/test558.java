package com.algorithm;

class Node4 {

    public boolean val;
    public boolean isLeaf;
    public Node4 topLeft;
    public Node4 topRight;
    public Node4 bottomLeft;
    public Node4 bottomRight;

    public Node4() {
    }

    public Node4(boolean _val, boolean _isLeaf, Node4 _topLeft, Node4 _topRight, Node4 _bottomLeft, Node4 _bottomRight) {
        val = _val;
        isLeaf = _isLeaf;
        topLeft = _topLeft;
        topRight = _topRight;
        bottomLeft = _bottomLeft;
        bottomRight = _bottomRight;
    }
};

public class test558 {
    public Node4 intersect(Node4 quadTree1, Node4 quadTree2) {
        if (quadTree1.isLeaf && quadTree2.isLeaf) {
            if (quadTree1.val) {
                return quadTree1;
            } else if (quadTree2.val) {
                return quadTree1;
            } else {
                return quadTree1;
            }
        }
        //递归四个格子
        Node4 ans = new Node4();
        ans.topLeft = intersect(quadTree1.isLeaf ? quadTree1 : quadTree1.topLeft, quadTree1.isLeaf ? quadTree2 : quadTree2.topLeft);
        ans.topRight = intersect(quadTree1.isLeaf ? quadTree1 : quadTree1.topRight, quadTree2.isLeaf ? quadTree2 : quadTree2.topRight);
        ans.bottomLeft = intersect(quadTree1.isLeaf ? quadTree1 : quadTree1.bottomLeft, quadTree2.isLeaf ? quadTree2 : quadTree2.bottomLeft);
        ans.bottomRight = intersect(quadTree1.isLeaf ? quadTree1 : quadTree1.bottomRight, quadTree2.isLeaf ? quadTree2 : quadTree2.bottomRight);
        boolean a = ans.topLeft.isLeaf && ans.topRight.isLeaf && ans.bottomLeft.isLeaf && ans.bottomRight.isLeaf;
        boolean b = ans.topLeft.val && ans.topRight.val && ans.bottomLeft.val && ans.bottomRight.val;
        boolean c = ans.topLeft.val || ans.topRight.val || ans.bottomLeft.val || ans.bottomRight.val;
        ans.isLeaf = a && (b || !c);
        ans.val = ans.topLeft.val;
        if (ans.isLeaf) ans.topLeft = ans.topRight = ans.bottomLeft = ans.bottomRight = null;
        return ans;
    }
}
