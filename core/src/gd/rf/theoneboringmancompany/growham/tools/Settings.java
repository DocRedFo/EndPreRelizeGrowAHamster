package gd.rf.theoneboringmancompany.growham.tools;

public abstract class Settings {
    public final static String ATLAS_TEXTURE_NAME = "file";

    public final static float CAMERA_HEIGHT = 810;
    public final static float CAMERA_WIDTH = 1440;

    public final static float FONT_SCALE_ORDINARY = 2.5f;
    public final static float FONT_SCALE_PLAY_INFORMATION = 1.2f;

    public final static class Prices{
        public final static String FOOD = "10";
        public final static String MED = "50";
        public final static String UPGRADE = "1000";
    }

    public final static class Hamster {
        public final static class Old {
            public final static String LEFT = "Pictures/Hamster/Left/Old/sprite.atlas";
            public final static String RIGHT = "Pictures/Hamster/Right/Old/sprite.atlas";
            public final static String SIT = "Pictures/Hamster/Sit/Old/sprite.atlas";
            public final static String SLEEP = "Pictures/Hamster/Sleep/Old/sleep.png";
        }
        public final static class Normal {
            public final static String LEFT = "Pictures/Hamster/Left/Normal/sprite.atlas";
            public final static String RIGHT = "Pictures/Hamster/Right/Normal/sprite.atlas";
            public final static String SIT = "Pictures/Hamster/Sit/Normal/sprite.atlas";
            public final static String SLEEP = "Pictures/Hamster/Sleep/Normal/sleep.png";
        }
        public final static class Small {
            public final static String LEFT = "Pictures/Hamster/Left/Small/sprite.atlas";
            public final static String RIGHT = "Pictures/Hamster/Right/Small/sprite.atlas";
            public final static String SIT = "Pictures/Hamster/Sit/Small/sprite.atlas";
            public final static String SLEEP = "Pictures/Hamster/Sleep/Small/sleep.png";
        }
    }

    public final static class Path {
        public final static String FONT = "BitmapFonts/text.fnt";

        public final static String UI_SKIN_TEXT_FIELD = "Skin/skin/uiskin.json";

        public final static String SERIALIZATION_FILE = "hamster.dat";

        public final static class Pictures {
            public final static class Backgrounds{
                public final static String MENU = "Pictures/Other/Backgrounds/menu.png";
                public final static String ALL = "Pictures/Other/Backgrounds/all.png";
                public final static String ROOM = "Pictures/Other/Room/room.png";
            }
            public final static class Buttons {
                public final static String EXIT = "Pictures/Buttons/NonAnimation/exit.png";
                public final static String BACK = "Pictures/Buttons/NonAnimation/back.png";
                public final static String BUY = "Pictures/Buttons/NonAnimation/buy.png";
                public final static String GYM = "Pictures/Buttons/NonAnimation/gym.png";
                public final static String MARKET = "Pictures/Buttons/NonAnimation/market.png";
                public final static String OK = "Pictures/Buttons/NonAnimation/ok.png";
                public final static String SLEEP = "Pictures/Buttons/NonAnimation/sleep.png";
                public final static String UPGRADE = "Pictures/Buttons/NonAnimation/upgrade.png";
            }
            public final static class Icons {
                public final static String WHO = "Pictures/Other/Scores/who.png";
                public final static String TIME = "Pictures/Other/Scores/time.png";
                public final static String FOOD = "Pictures/Other/food.png";
                public final static String MED = "Pictures/Other/med.png";
                public final static String UPGRADE = "Pictures/Other/updateRoom.png";
            }
            public final static class Emotions {
                public final static String GOOD = "Pictures/Other/Emotions/2.png";
                public final static String NORMAL = "Pictures/Other/Emotions/1.png";
                public final static String BAD = "Pictures/Other/Emotions/0.png";
            }
            public final static class Images {
                public final static String LOGO = "Pictures/Other/logo.png";
                public final static String TUBE = "Pictures/Other/Room/tube.png";
            }
        }

        public final static class Audio {
            public final static class Sounds {
                public final static String BUTTON = "Audio/UI/button.mp3";
                public final static String OK = "Audio/UI/ok.mp3";
                public final static String HEALTH = "Audio/UI/health.mp3";
                public final static String LEVEL_UP = "Audio/UI/levelup.mp3";
                public final static String PAY = "Audio/UI/pay.mp3";
            }

            public final static class Music {
                public final static String SCORES = "Audio/Music/Scores.mp3";
                public final static String MENU = "Audio/Music/Menu.mp3";
                public final static String PLAY = "Audio/Music/Play.mp3";
            }
        }

        public final static class TextureAtlas {
            public final static String PLAY_BUTTON_ATLAS =
                    "Pictures/Buttons/Animation/Play/sprite.atlas";
            public final static String SCORES_BUTTON_ATLAS =
                    "Pictures/Buttons/Animation/Play/sprite.atlas";
            public final static String BREAK_AND_PLAY_BUTTON_ATLAS =
                    "Pictures/Buttons/Animation/BreakAndPlay/sprite.atlas";
        }
    }

    public final static class MusicAndSound{
        public final static float SOUND_VOLUME = 30/100f;
        public final static float MUSIC_VOLUME = 20/100f;
    }

    public final static class Animation {
        public final static float MENU_BUTTON_ANIMATION_SPEED = 1 / 45f;
        public final static float HAMSTER_ANIMATION_SPEED = 1 / 65f;
    }

    public final static class Text {
        public final static String WELCOME = "Нажмите дважды для начала";
        public final static String ENTER_NAME = "Введите имя";

        public final static String HUNGRY = "Голод";
        public final static String HEALTH = "Здоровье";
        public final static String DAY = "День";
        public final static String MONEY = "Деньги";
    }
}

