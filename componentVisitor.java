package miniTwitter;
public interface componentVisitor {
    Tree visit(Tree root, userName userName);
    Tree visit(Tree root, userGroup userGroup);
}
