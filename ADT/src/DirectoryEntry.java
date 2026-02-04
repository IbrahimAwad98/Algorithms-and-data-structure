public class DirectoryEntry {

    public String name;
    public String number;

    public DirectoryEntry(String name, String number){
        this.name=name;
        this.number=number;
    }

    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(obj == null || getClass() != obj.getClass()){
            return false;
        }

        //omvandla typen (cast)
        DirectoryEntry other = (DirectoryEntry) obj;

        //bara med namn (ej telefone)
        return this.name.equals(other.name);
    }
}


