package FominaKat.NoteBook;


import java.util.Objects;

public class Laptop {
    private String fabric;
    private String name;
    private int ram;
    private int ssd;
    private OS os;
    private Color color;

    public Laptop(String fabric, String name, int ram, int ssd, OS os, Color color) {
        this.fabric = fabric;
        this.name = name;
        this.ram = ram;
        this.ssd = ssd;
        this.os = os;
        this.color = color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fabric, name, ram, ssd, os, color);
    }

    @Override
    public boolean equals(Object o) {
        if ((o == null) || (this.getClass() != o.getClass())) {
            return false;
        } else {
            Laptop lpt = (Laptop) o;
            return ((this.ram == lpt.getRam()) &&
                    (this.ssd == lpt.getSsd()) &&
                    (this.os == lpt.getOs()) &&
                    (this.color.equals(lpt.getColor())) &&
                    (this.fabric.equals(lpt.getFabric())) &&
                    (this.name.equals(lpt.getName())));
        }
    }

    @Override
    public String toString() {
        return String.format("Ноутбук %s %s %s RAM %d Гб, HDD %d Гб, ОС- %s",
                fabric, name, color.toString(), ram, ssd, os.toString());
    }

    //region Getter-Setter
    public String getFabric() {
        return fabric;
    }

    public void setFabric(String fabric) {
        this.fabric = fabric;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = Math.min(ram, ram / 8 * 8); //если переданное значение не кратно 8 - округляем в меньшую сторону)

    }

    public int getSsd() {
        return ssd;
    }

    public void setSsd(int ssd) {
        this.ssd = ssd;
    }

    public OS getOs() {
        return os;
    }

    public void setOs(OS os) {
        this.os = os;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    //endregion
}


