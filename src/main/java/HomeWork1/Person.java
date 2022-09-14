package HomeWork1;

public class Person {
    String firstName;
    String lastName;
    String middleName;
    String country;
    String address;
    String phone;
    int age;
    String gender;

    public static class Builder{
        private final Person person;

        public Builder(){
            this.person = new Person();
        }

        public Builder withFirstName(String firstName){
            person.firstName=firstName;
            return this;
        }

        public Builder withLastName(String lastName){
            person.lastName=lastName;
            return this;
        }

        public Builder withMiddleName(String middleName){
            person.middleName=middleName;
            return this;
        }

        public Builder withCountry(String country){
            person.country=country;
            return this;
        }

        public Builder withAddress(String address){
            person.address = address;
            return this;
        }

        public Builder withPhone(String phone){
            person.phone = phone;
            return this;
        }

        public Builder withAddress(int age){
            person.age = age;
            return this;
        }

        public Builder withGender(String gender){
            person.gender = gender;
            return this;
        }

        public Person build(){
            return person;
        }
    }

    public static Builder createBuilder() {
        return new Builder();
    }

}
