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
        System.out.println("CHECK");
        for (final Block block : this) {
            final BoundingBox blockBox = block.bound();
            final BoundingBox entityBox = entity.bound();
            if (Intersection.checkForCollision(blockBox, entityBox)) {
                final BoundingBoxQuad quad = new BoundingBoxQuad(entityBox);
                if (Intersection.checkForCollision(blockBox, quad.top())) {
                    entity.collidedTop(block);
                }
                if (Intersection.checkForCollision(blockBox, quad.bottom())) {
                    entity.collidedBottom(block);
                }
            }
        }
    }
}
