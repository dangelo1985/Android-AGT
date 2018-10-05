package agt.br.com.agt.model;

public class Rotas {
    private Long id_rotas;
    private String nome_rotas;
    private String latitude_rotas;
    private String longitude_rotas;


    public Long getId_rotas() {
        return id_rotas;
    }

    public void setId_rotas(Long id_rotas) {
        this.id_rotas = id_rotas;
    }

    public String getNome_rotas() {
        return nome_rotas;
    }

    public void setNome_rotas(String nome_rotas) {
        this.nome_rotas = nome_rotas;
    }

    public String getLatitude_rotas() {
        return latitude_rotas;
    }

    public void setLatitude_rotas(String latitude_rotas) {
        this.latitude_rotas = latitude_rotas;
    }

    public String getLongitude_rotas() {
        return longitude_rotas;
    }

    public void setLongitude_rotas(String longitude_rotas) {
        this.longitude_rotas = longitude_rotas;
    }
}
