public class PlayRoles {
    public static void main(String[] args) {
        String [] roles = {
                "Городничий","Аммос Федорович",
                "Артемий Филиппович",
                "Лука Лукич"};
        String [] textLines ={ "Городничий: Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор.",
                "Аммос Федорович: Как ревизор?",
                "Артемий Филиппович: Как ревизор?",
                "Городничий: Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем.",
                "Аммос Федорович: Вот те на!",
                "Артемий Филиппович: Вот не было заботы, так подай!",
                "Лука Лукич: Господи боже! еще и с секретным предписаньем!"};

        StringBuilder current = new StringBuilder();
        StringBuilder finalstring = new StringBuilder();
        String currentrole;
        int rolecharnum;
        for (int i = 0; i < roles.length; i++) {
            rolecharnum = roles[i].length();
            finalstring.append(roles[i] + ":" + '\n');
            for (int j = 0; j < textLines.length; j++) {
                current.append(textLines[j]);
                currentrole = current.substring(0, rolecharnum + 1).toString();
                if (currentrole.equals(roles[i] + ":")) {
                   finalstring.append(j + 1 + ") " + current.substring(rolecharnum + 1, current.length()) + '\n');
                }
                current.delete(0, current.length());
            }
            finalstring.append('\n');
        }
        finalstring.toString();
        System.out.println(finalstring);
    }
}
