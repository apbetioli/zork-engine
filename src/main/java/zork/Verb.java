package zork;

public enum Verb implements Executable {

	I {
		@Override
		public String execute(Game game) {
			return game.inventory();
		}
	},
	INVENTORY {
		@Override
		public String execute(Game game) {
			return game.inventory();
		}
	},
	LOOK {
		@Override
		public String execute(Game game) {
			return game.look();
		}
	},
	OPEN {
		@Override
		public String execute(Game game) {
			return game.open();
		}
	},
	WELCOME {
		@Override
		public String execute(Game game) {
			return game.welcome();
		}
	}, 
	CLOSE {
		@Override
		public String execute(Game game) {
			return game.close();
		}
	};

}
