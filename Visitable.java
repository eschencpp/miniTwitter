package miniTwitter;

public abstract class Visitable {
    public abstract Tree accept(Visitor v, Tree userComp);
    public abstract boolean accept(validationVisitor v);
    public abstract String accept(Visitor v);
}
