package game_components;

		public class Target {
	
			private int TargetID;
			private int TargetSubRoundID;
			private int TargetStatus;
			private int HitThreshold;
			private int HitCount;
			private int TotalHitCount;
			
			public Target (int TargetID, int TargetSubRoundID, int TargetStatus, int HitThreshold, 
	                int HitCount, int TotalHitCount){
					this.TargetID = TargetID;
					this.TargetSubRoundID = TargetSubRoundID;
					this.TargetStatus = TargetStatus;
					this.HitThreshold = HitThreshold; 
					this.HitCount = HitCount; 
					this.TotalHitCount = TotalHitCount;
					}
			public int getTargetID() {
				
				return TargetID;
			}

			public void setTargetID(int TargetID) {
				this.TargetID = TargetID;
			}
			
			public int getTargetSubRoundID() {
				
				return TargetSubRoundID;
			}

			public void setTargetRoundID(int TargetRoundID) {
				this.TargetSubRoundID = TargetRoundID;
			}

			public int getTargetStatus() {
				return TargetStatus;
			}

			public void setTargetStatus(int TargetStatus) {
				this.TargetStatus = TargetStatus;
			}
			
			public int getHitThreshold() {
				return HitThreshold;
			}

			public void setHitThreshold(int HitThreshold) {
				this.HitThreshold = HitThreshold;
			}

			public int getHitCount() {
				return HitCount;
			}

			public void setHitCount(int HitCount) {
				this.HitCount = HitCount;
			}
			
			public int getTotalHitCount() {
				return TotalHitCount;
			}
			
			public void setTotalHitCount(int TotalHitCount) {
				this.TotalHitCount = TotalHitCount;
			}

}