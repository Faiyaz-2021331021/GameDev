package util;

public class Constants
{
    public static class Directions
        {
            public static final int LEFT = 0;
            public static final int UP = 1;
            public static final int RIGHT = 2;
            public static final int DOWN = 3;
        }
    public static class PlayerConstants
    {
        public static final int IDLE = 0;
        public static final int RUNNING = 1;
        public static final int JUMP = 2;
        public static final int FALLING = 3;
        public static final int GROUND = 4;
        public static final int HIT = 5;
        public static final int ATTACK_1 = 6;
        public static final int ATTACK_JUMP_1 = 7;
        public static final int ATTACK_JUMP_2 = 8;

        public static int getSpriteAmount(int player_action)
        {
            switch(player_action)
            {
                case PlayerConstants.RUNNING:
                    return 6;
                case PlayerConstants.IDLE:
                    return 5;
                case PlayerConstants.HIT:
                    return 4;
                case PlayerConstants.JUMP:
                case PlayerConstants.ATTACK_1:
                case PlayerConstants.ATTACK_JUMP_1:
                case PlayerConstants.ATTACK_JUMP_2:
                    return 3;
                case PlayerConstants.GROUND:
                    return 2;
                case PlayerConstants.FALLING:
                default:
                    return 1;
            }
        }
    }
}
