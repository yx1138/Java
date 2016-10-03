public enum Biome {
	ZB_I("Equatorial, always moist, little temperature seasonality"),
	ZB_II("Tropical, summer rainy season and cooler “winter” dry season"),
	ZB_III("Subtropical, highly seasonal, arid climate"),
	ZB_IV("Mediterranean, winter rainy season and summer drought"),
	ZB_V("Warm temperate, occasional frost, often with summer rainfall maximum"),
	ZB_VI("Nemoral, moderate climate with winter freezing"),
	ZB_VII("Continental, arid, with warm or hot summers and cold winters"),
	ZB_VIII("Boreal, cold temperate with cool summers and long winters"), 
	ZB_IX("Polar, short, cool summers and long, cold winters");

	private String description;
	Biome(String description){
		this.description = description;
	}
	public String getDescription(){
		return description;
	}
	public static void print(Biome ... biomes){
		for (Biome biome : biomes){
			System.out.println(biome.description);
			}
	}

}