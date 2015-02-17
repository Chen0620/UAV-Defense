package game_components;


	public class DroneInfo {
		private int ID; 
		private int totalWin; 
		private float totalTimeDown;
		private float totalTimeUp;
		private int totalLoss; 
		private int isActive;  
		
		public DroneInfo (int ID, int totalWin, float upTime, float totalTimeDown, 
				                int totalLoss, int isActive){
			this.ID = ID;
			this.totalWin = totalWin;
			this.totalTimeDown = totalTimeDown;
			this.totalLoss = totalLoss; 
			this.isActive = isActive; 
		}

		public int getTotalWin() {
			return totalWin;
		}

		public void setTotalWin(int totalWin) {
			this.totalWin = totalWin;
		}

		public float getTotalTimeDown() {
			return totalTimeDown;
		}

		public void setTotalTimeDown(float totalTimeDown) {
			this.totalTimeDown = totalTimeDown;
		}

		public float getTotalTimeUp() {
			return totalTimeUp;
		}

		public void setTotalTimeUp(float totalTimeUp) {
			this.totalTimeUp = totalTimeUp;
		}

		public int getTotalLoss() {
			return totalLoss;
		}

		public void setTotalLoss(int totalLoss) {
			this.totalLoss = totalLoss;
		}

		public int getIsActive() {
			return isActive;
		}

		public void setIsActive(int isActive) {
			this.isActive = isActive;
		}
	}


