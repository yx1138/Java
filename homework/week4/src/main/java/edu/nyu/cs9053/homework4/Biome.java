public enum Biome {
	ZB_I{
		public String getDescription(){
			return "Equatorial, always moist, little temperature seasonality";
		}
	},
	ZB_II{
		public String getDescription(){
			return "Tropical, summer rainy season and cooler “winter” dry season";
		}
	},
	ZB_III{
		public String getDescription(){
			return "Subtropical, highly seasonal, arid climate";
		}
	},
	ZB_IV{
		public String getDescription(){
			return "Mediterranean, winter rainy season and summer drought";
		}
	},
	ZB_V{
		public String getDescription(){
			return "Warm temperate, occasional frost, often with summer rainfall maximum";
		}
	},
	ZB_VI{
		public String getDescription(){
			return "Nemoral, moderate climate with winter freezing";
		}
	},
	ZB_VII{
		public String getDescription(){
			return "Continental, arid, with warm or hot summers and cold winters";
		}
	},
	ZB_VIII{
		public String getDescription(){
			return "Boreal, cold temperate with cool summers and long winters";
		}
	},
	ZB_IX{
		public String getDescription(){
			return "Polar, short, cool summers and long, cold winters";
		}
	};
	public abstract String getDescription();
	public static void print(Biome ... biomes){
		for (Biome biome : biomes){
			System.out.println(biome.getDescription());
			}
	}

}