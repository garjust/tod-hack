package niktgar.tod.geometry;

import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(fluent = true)
@Data
public class Vector {

    public float x;
    public float y;

    public Vector(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Vector(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public int snappedX() {
        return Math.round(x);
    }

    public int snappedY() {
        return Math.round(y);
    }
}