package niktgar.tod.block;

import java.util.ArrayList;

import niktgar.tod.collision.BoundingBox;
import niktgar.tod.collision.BoundingBoxQuad;
import niktgar.tod.collision.Intersection;
import niktgar.tod.entity.Entity;

public class BlockLayer extends ArrayList<Block> {

    private static final long serialVersionUID = 1L;

    public BlockLayer() {
        super();
    }

    public void checkForCollisions(final Entity entity) {
        for (final Block block : this) {
            final BoundingBox blockBox = block.bound();
            final BoundingBox entityBox = entity.bound();
            if (Intersection.checkForCollision(blockBox, entityBox)) {
                final BoundingBoxQuad quad = new BoundingBoxQuad(entityBox);
                if (Intersection.checkForCollision(blockBox, quad.top())) {
                    System.err.println("TOP");
                    entity.collidedTop(block);
                } else if (Intersection.checkForCollision(blockBox, quad.bottom())) {
                    System.err.println("BOTTOM");
                    entity.collidedBottom(block);
                } else if (Intersection.checkForCollision(blockBox, quad.left())) {
                    System.err.println("LEFT");
                    entity.collidedLeft(block);
                } else if (Intersection.checkForCollision(blockBox, quad.right())) {
                    System.err.println("RIGHT");
                    entity.collidedRight(block);
                }
            }
        }
    }
}
