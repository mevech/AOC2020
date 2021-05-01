package org.acme.day4;

public enum ProcessState {
    INIT {
        @Override
        public ProcessState next(int character) {
            if (character == -1) {
                return FINISH;
            }
            return KEY;
        }
    },
    KEY {
        @Override
        public ProcessState next(int character) {
            switch (character) {
                case ':': return VALUE;
                case -1 : return FINISH;
            }
            return KEY;
        }
    },
    VALUE {
        @Override
        public ProcessState next(int character) {
            switch (character) {
                case ' ': return END_OF_PAIR_SPACE;
                case '\n': return END_OF_PAIR_LINE;
                case -1 : return FINISH;
            }
            return VALUE;
        }
    },
    END_OF_PAIR_SPACE {
        @Override
        public ProcessState next(int character) {
            switch (character) {
                case ' ': return END_OF_PAIR_SPACE;
                case '\n': return END_OF_PAIR_LINE;
                case ':': return VALUE;
                case -1 : return FINISH;
            }
            return KEY;
        }
    },
    END_OF_PAIR_LINE {
        @Override
        public ProcessState next(int character) {
            switch (character) {
                case ' ': return END_OF_PAIR_SPACE;
                case '\n': return END_OF_PASSPORT;
                case ':': return VALUE;
                case -1 : return FINISH;
            }
            return KEY;
        }
    },
    END_OF_PASSPORT {
        @Override
        public ProcessState next(int character) {
            return null;
        }
    },
    FINISH {
        @Override
        public ProcessState next(int character) {
            return null;
        }
    };


    public abstract ProcessState next(int character);
}
