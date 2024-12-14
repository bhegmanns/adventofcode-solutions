package de.hegmanns.training.aoc.common.geometric;

public record Point(int x, int y) {

    public boolean isIn(Line line) {
        if (line.from().equals(this) || line.to().equals(this)) {
            return true;
        }
        int diffX = line.from().x - line.to().x;
        int diffY = line.from().y - line.to().y;
        int y = x * diffY / diffX + line.from().y - line.from().x * diffY / diffX;
        return this.x>=line.from().x && this.x<=line.to().x && y==this.y;
    }
}
