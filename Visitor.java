package miniTwitter;
import java.util.ArrayList;

public abstract class Visitor {
    public abstract Tree visit(Tree root, userName userName);
    public abstract Tree visit(Tree root, userGroup userGroup);
 }