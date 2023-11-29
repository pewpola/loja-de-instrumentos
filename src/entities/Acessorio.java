package entities;

public class Acessorio extends Produto {

    private String compatibilidadeInstrumento;
    private String material;

    public Acessorio(int id, String tipo, String marca, String modelo, double preco, String compatibilidadeInstrumento, String material) {
        super(id, tipo, marca, modelo, preco);
        this.compatibilidadeInstrumento = compatibilidadeInstrumento;
        this.material = material;
    }

    public String getMaterial() {
        return material;
    }

    public String getCompatibilidadeInstrumento() {
        return compatibilidadeInstrumento;
    }
}
