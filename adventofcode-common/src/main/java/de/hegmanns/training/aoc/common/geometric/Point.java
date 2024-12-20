package de.hegmanns.training.aoc.common.geometric;

public record Point(int x, int y) {
    public static final Point DIRECTION_ONEUP = new Point(0, -1);
    public static final Point DIRECTION_ONELEFT = new Point(-1, 0);
    public static final Point DIRECTION_ONEDOWN = new Point(0, 1);
    public static final Point DIRECTION_ONERIGHT = new Point(1, 0);

    public boolean isIn(Line line) {
        if (line.from().equals(this) || line.to().equals(this)) {
            return true;
        }
        int diffX = line.from().x - line.to().x;
        int diffY = line.from().y - line.to().y;
        int y = x * diffY / diffX + line.from().y - line.from().x * diffY / diffX;
        return this.x>=line.from().x && this.x<=line.to().x && y==this.y;
    }

    public Point move(Point direction) {
        return new Point(x + direction.x, y + direction.y);
    }

    public boolean isInside(int width, int height) {
        return x>=0 && y>=0 && x<width && y<height;
    }
}
