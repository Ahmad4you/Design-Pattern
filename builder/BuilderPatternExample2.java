package builder;


//Product class
class House {
 private final String foundation;
 private final String structure;
 private final String roof;
 private final int numBedrooms;
 private final int numBathrooms;
 private final boolean hasGarage;

 private House(HouseBuilder builder) {
     this.foundation = builder.foundation;
     this.structure = builder.structure;
     this.roof = builder.roof;
     this.numBedrooms = builder.numBedrooms;
     this.numBathrooms = builder.numBathrooms;
     this.hasGarage = builder.hasGarage;
 }

 public String getFoundation() {
     return foundation;
 }

 public String getStructure() {
     return structure;
 }

 public String getRoof() {
     return roof;
 }

 public int getNumBedrooms() {
     return numBedrooms;
 }

 public int getNumBathrooms() {
     return numBathrooms;
 }

 public boolean hasGarage() {
     return hasGarage;
 }

 @Override
 public String toString() {
     return "House{" +
             "foundation='" + foundation + '\'' +
             ", structure='" + structure + '\'' +
             ", roof='" + roof + '\'' +
             ", numBedrooms=" + numBedrooms +
             ", numBathrooms=" + numBathrooms +
             ", hasGarage=" + hasGarage +
             '}';
 }

 // Builder class
 public static class HouseBuilder {
     private String foundation;
     private String structure;
     private String roof;
     private int numBedrooms;
     private int numBathrooms;
     private boolean hasGarage;

     public HouseBuilder setFoundation(String foundation) {
         this.foundation = foundation;
         return this;
     }

     public HouseBuilder setStructure(String structure) {
         this.structure = structure;
         return this;
     }

     public HouseBuilder setRoof(String roof) {
         this.roof = roof;
         return this;
     }

     public HouseBuilder setNumBedrooms(int numBedrooms) {
         this.numBedrooms = numBedrooms;
         return this;
     }

     public HouseBuilder setNumBathrooms(int numBathrooms) {
         this.numBathrooms = numBathrooms;
         return this;
     }

     public HouseBuilder setHasGarage(boolean hasGarage) {
         this.hasGarage = hasGarage;
         return this;
     }

     public House build() {
         return new House(this);
     }
 }
}


public class BuilderPatternExample2 {
	
	public static void main(String[] args) {
        House house = new House.HouseBuilder()
                .setFoundation("Concrete")
                .setStructure("Wood")
                .setRoof("Asphalt Shingles")
                .setNumBedrooms(3)
                .setNumBathrooms(2)
                .setHasGarage(true)
                .build();

        System.out.println(house);
    }
}
