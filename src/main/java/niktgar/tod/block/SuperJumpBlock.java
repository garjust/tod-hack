package niktgar.tod.block;

import niktgar.tod.entity.Entity;
import niktgar.tod.entity.MovementState;
import niktgar.tod.sprite.Sprite;


public class SuperJumpBlock extends Block {
    public SuperJumpBlock(Sprite sprite, int x, int y) {
        super(sprite, x, y);
    }
    
    @Override
    public void updateMovementState(Entity entity) {
        // change movementState of entity
        entity.movementState = MovementState.SUPER_JUMP;
    }
}