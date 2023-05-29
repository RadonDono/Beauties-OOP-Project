import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
class File
{
    String name;
    String content;
}
class Git
{
    String name;
    ArrayList<File> filesNames=new ArrayList<>();
    ArrayList<File> stagfile=new ArrayList<>();
    ArrayList<Commit> commitArea=new ArrayList<>();
}
class Commit
{
    String name;
    ArrayList<File> commit=new ArrayList<>();
}
public class Main {
    public static void main(String[] args) {
        ArrayList<String> vocab=new ArrayList<>();
        ArrayList<Git> rep=new ArrayList<>();
        Scanner input = new Scanner(System.in);
        String in;
        String [] Three_spilit;
        Three_spilit=new String [3];
        in=input.nextLine();
        vocab.add(in);
        while(!(in).equals("end"))
        {
            in=input.nextLine();
            vocab.add(in);
        }
        vocab.remove(vocab.size()-1);
        for (int i = 0; i < vocab.size(); i++) {
            in= vocab.get(i);
            if (in.contains("new repository ")) {
                Three_spilit = in.split(" ",3);
                boolean a = true;
                for (Git git : rep) {
                    if (Objects.equals(git.name, Three_spilit[2])) {
                        a = false;
                        break;
                    }
                }
                if (a) {
                    Git nemd = new Git();
                    rep.add(nemd);
                    nemd.name = Three_spilit[2];
                    System.out.println("Repository created successfully! ");
                } else {
                    System.out.println("Repository with this name already exists ");
                }
            }
            if (in.contains("open repository ")) {
                int numb=-1;
                Three_spilit = in.split(" ",3);
                for (int y=0;y<rep.size();y++) {
                    if (Objects.equals(rep.get(y).name, Three_spilit[2])) {
                        numb=y;
                        break;
                    }
                }
                if (numb!=-1) {
                    rep.get(numb).name = Three_spilit[2];
                    System.out.println("Repository " + Three_spilit[2] + " opened successfully! ");
                    in=vocab.get(++i);
                    while (!in.contains("open repository "))
                    {
                        if(in.contains("new file "))
                        {
                            boolean b=true;
                            String [] four_spilit;
                            four_spilit=new String [4];
                            four_spilit=in.split(" ",4);
                            for (int j=0;j<rep.get(numb).filesNames.size();j++)
                            {
                                if (Objects.equals(four_spilit[2], rep.get(numb).filesNames.get(j).name)) {
                                    b = false;
                                    break;
                                }
                            }
                            if (b)
                            {
                                File nemid = new File();
                                rep.get(numb).filesNames.add(nemid);
                                nemid.name = four_spilit[2];
                                nemid.content = four_spilit[3];
                                System.out.println("File created successfully! ");
                            }
                            else
                            {
                                System.out.println("File with this name already exists in this Repository");
                            }
                            i++;
                        }
                        else if(in.contains("edit file "))
                        {
                            boolean b=false;
                            int bn=-1;
                            String [] four_spilit;
                            four_spilit=new String [4];
                            four_spilit=in.split(" ",4);
                            for (int j=0;j<rep.get(numb).filesNames.size();j++)
                            {
                                if (Objects.equals(four_spilit[2], rep.get(numb).filesNames.get(j).name)) {
                                    b = true;
                                    bn=j;
                                    break;
                                }
                            }
                            if (b)
                            {
                                rep.get(numb).filesNames.get(bn).content=four_spilit[3];
                                System.out.println("Edited successfully! ");
                            }
                            else
                            {
                                System.out.println("No file exists with the given name");
                            }
                            i++;
                        }
                        else if(in.contains("add -all"))
                        {
                            rep.get(numb).stagfile.addAll(rep.get(numb).filesNames);
                            System.out.println("Added");
                            i++;
                        }
                        else if(in.contains("add "))
                        {
                            int gn=-1;
                            String [] two_spilit;
                            two_spilit=new String [2];
                            two_spilit=in.split(" ",2);
                            for (int j=0;j<rep.get(numb).filesNames.size();j++)
                            {
                                if (Objects.equals(two_spilit[1], rep.get(numb).filesNames.get(j).name))
                                    gn=j;
                            }
                            if (gn==-1)
                                System.out.println("No file exists with the given name");
                            else
                            {
                                rep.get(numb).stagfile.add(rep.get(numb).filesNames.get(gn));
                                System.out.println("Added");
                            }
                            i++;
                        }
                        else if(in.contains("commit "))
                        {
                            String [] two_spilit;
                            two_spilit=new String [2];
                            two_spilit=in.split(" ",2);
                            if (rep.get(numb).stagfile.size()!=0)
                            {
                                Commit ab=new Commit();
                                ab.name=two_spilit[1];
                                for (int k=0;k<rep.get(numb).stagfile.size();k++)
                                {
                                    File adc=new File();
                                    adc.name=" ";
                                    adc.content=" ";
                                    ab.commit.add(adc);
                                }
                                for (int k=0;k<rep.get(numb).stagfile.size();k++)
                                {
                                    ab.commit.get(k).name=rep.get(numb).stagfile.get(k).name;
                                    ab.commit.get(k).content=rep.get(numb).stagfile.get(k).content;
                                }
                                rep.get(numb).commitArea.add(ab);
                                System.out.println("Committed ");
                            }
                            else
                            {
                                System.out.println("No files are added");
                            }
                            i++;
                        }
                        else if(in.contains("un-stage -all"))
                        {
                            for (int k=0;k<rep.get(numb).stagfile.size();k++)
                                rep.get(numb).stagfile.remove(k);
                            System.out.println("Removed from stage");
                            i++;
                        }
                        else if (in.contains("un-stage "))
                        {
                            int gn=-1;
                            String [] two_spilit;
                            two_spilit=new String [2];
                            two_spilit=in.split(" ",2);
                            for (int j=0;j<rep.get(numb).filesNames.size();j++)
                            {
                                if (Objects.equals(two_spilit[1], rep.get(numb).filesNames.get(j).name))
                                    gn=j;
                            }
                            if (gn==-1)
                                System.out.println("No file exists with the given name");
                            else
                            {
                                int jk=-1;
                                for (int k=0;k<rep.get(numb).stagfile.size();k++)
                                {
                                    if(Objects.equals(rep.get(numb).stagfile.get(k).name, rep.get(numb).filesNames.get(gn).name))
                                        jk=k;
                                }
                                if (jk>0)
                                {
                                    rep.get(numb).stagfile.remove(jk);
                                    System.out.println("Removed from stage ");
                                }
                                else
                                    System.out.println("No file exists with the given name");
                            }
                            i++;
                        }
                        else if (in.contains("remove "))
                        {
                            int gn=-1;
                            String [] two_spilit;
                            two_spilit=new String [2];
                            two_spilit=in.split(" ",2);
                            for (int j=0;j<rep.get(numb).filesNames.size();j++)
                            {
                                if (Objects.equals(two_spilit[1], rep.get(numb).filesNames.get(j).name))
                                    gn=j;
                            }
                            if (gn==-1)
                                System.out.println("No file exists with the given name");
                            else
                                rep.get(numb).filesNames.remove(gn);
                            i++;
                        }
                        else if (in.contains("restore "))
                        {
                            String []jedai=in.split(" ",3);
                            if (jedai.length==2)
                            {
                            String [] two_spilit;
                            two_spilit=new String [2];
                            two_spilit=in.split(" ",2);
                            boolean ef;
                            int km=-1;
                            ef=two_spilit[1].matches("\\d");
                            if (ef)
                            {
                                km = Integer.parseInt(two_spilit[1]);
                                if ((km>0)&&(km<=rep.get(numb).commitArea.size()))
                                {
                                    for (int k = 0; k < rep.get(numb).filesNames.size(); k++) {
                                        for (int j = 0; j < rep.get(numb).commitArea.get(km-1).commit.size(); j++) {
                                            if (Objects.equals(rep.get(numb).commitArea.get(km-1).commit.get(j).name, rep.get(numb).filesNames.get(k).name))
                                                rep.get(numb).filesNames.get(k).content = rep.get(numb).commitArea.get(km-1).commit.get(j).content;
                                        }
                                    }
                                    System.out.println("Restored");
                                }
                                else
                                    System.out.println("No commit exists with the given number");
                            }
                            else
                            {
                                for (int j=0;j<rep.get(numb).commitArea.size();j++)
                                {
                                    if (Objects.equals(two_spilit[1], rep.get(numb).commitArea.get(j).name))
                                        km=j;
                                }
                                if(km>-1)
                                {
                                for (int k=0;k<rep.get(numb).filesNames.size();k++)
                                {
                                    for (int j=0;j<rep.get(numb).commitArea.get(km).commit.size();j++)
                                    {
                                        if (Objects.equals(rep.get(numb).commitArea.get(km).commit.get(j).name, rep.get(numb).filesNames.get(k).name))
                                            rep.get(numb).filesNames.get(k).content=rep.get(numb).commitArea.get(km).commit.get(j).content;
                                    }
                                }
                                    System.out.println("Restored");
                                }
                                else
                                    System.out.println("No commit exists with the given name");
                            }
                            }
                            else
                            {
                                String[] three_spilit =new String[3];
                                three_spilit=in.split(" ",3);
                                boolean ef;
                                int km=-1;
                                int m=-1;
                                int pk=-1;
                                ef=three_spilit[2].matches("\\d");
                                if (ef)
                                {
                                    km = Integer.parseInt(three_spilit[2]);
                                    if ((km>0)&&(km<=rep.get(numb).commitArea.size()))
                                    {
                                        for (int j=0;j<rep.get(numb).filesNames.size();j++)
                                        {
                                            if (Objects.equals(three_spilit[1], rep.get(numb).filesNames.get(j).name))
                                                m=j;
                                        }
                                        for (int j=0;j<rep.get(numb).commitArea.get(km-1).commit.size();j++)
                                        {
                                            if (Objects.equals(three_spilit[1], rep.get(numb).commitArea.get(km-1).commit.get(j).name))
                                                pk=j;
                                        }
                                        if (pk>-1)
                                        {
                                            rep.get(numb).filesNames.get(m).content=rep.get(numb).commitArea.get(km-1).commit.get(pk).content;
                                            System.out.println("Restored");
                                        }
                                        else
                                            System.out.println("No file exists in the given commit with the given name");
                                    }
                                    else
                                        System.out.println("No commit exists with the given number");
                                }
                                else
                                {
                                    for (int j=0;j<rep.get(numb).commitArea.size();j++)
                                    {
                                        if (Objects.equals(three_spilit[2], rep.get(numb).commitArea.get(j).name))
                                            km=j;
                                    }
                                    if(km>=0)
                                    {
                                        for (int j=0;j<rep.get(numb).filesNames.size();j++)
                                        {
                                            if (Objects.equals(three_spilit[1], rep.get(numb).filesNames.get(j).name))
                                                m=j;
                                        }
                                        for (int j=0;j<rep.get(numb).commitArea.get(km).commit.size();j++)
                                        {
                                            if (Objects.equals(three_spilit[1], rep.get(numb).commitArea.get(km).commit.get(j).name))
                                                pk=j;
                                        }
                                        if (pk>-1)
                                        {
                                            rep.get(numb).filesNames.get(m).content=rep.get(numb).commitArea.get(km).commit.get(pk).content;
                                            System.out.println("Restored");
                                        }
                                    }
                                    else
                                        System.out.println("No commit exists with the given name");
                                }
                            }
                            i++;
                        }
                        else if (in.contains("diff "))
                        {

                            i++;
                        }
                        else if (in.contains("show "))
                        {
                            String [] two_spilit;
                            two_spilit=new String [2];
                            two_spilit=in.split(" ",2);
                            int km=-1;
                            for (int j=0;j<rep.get(numb).filesNames.size();j++)
                            {
                                if (Objects.equals(two_spilit[1], rep.get(numb).filesNames.get(j).name))
                                    km=j;
                            }
                            if (km>-1)
                            {
                                StringBuilder abc=new StringBuilder();
                                char [] abs;
                                abs=rep.get(numb).filesNames.get(km).content.toCharArray();
                                for (int k=1;k<(abs.length-1);k++)
                                {
                                    abc.append(abs[k]);
                                }
                                System.out.println(abc);
                            }
                            else
                                System.out.println("No file exists with the given name ");
                            i++;
                        }
                        else if (in.contains("status"))
                        {
                            int it=0;
                            for (int j=0;j<rep.get(numb).filesNames.size();j++)
                            {
                                boolean tik=false;
                                for (int p=0;p<rep.get(numb).stagfile.size();p++)
                                {
                                    if (Objects.equals(rep.get(numb).filesNames.get(j).name,rep.get(numb).stagfile.get(p).name))
                                    {
                                        tik=true;
                                        break;
                                    }
                                }
                                StringBuilder abc=new StringBuilder();
                                char [] abs;
                                abs=rep.get(numb).filesNames.get(j).name.toCharArray();
                                for (int k=1;k<(abs.length-1);k++)
                                {
                                    abc.append(abs[k]);
                                }
                                if (tik)
                                {
                                    System.out.println(abc+" staged");
                                }
                                else
                                {
                                    System.out.println(abc+" not staged");
                                }
                                it++;
                            }
                            if (it==0)
                                System.out.println("There are no files in the repository");
                            i++;
                        }
                        else if (in.contains("log"))
                        {
                            if (rep.get(numb).commitArea.size()<1)
                            {
                                System.out.println("No commits have been done yet ");
                            }
                            else
                            {
                            for (int p=0;p<rep.get(numb).commitArea.size();p++)
                            {
                                StringBuilder abc=new StringBuilder();
                                char [] abs;
                                abs=rep.get(numb).commitArea.get(p).name.toCharArray();
                                for (int k=1;k<(abs.length-1);k++)
                                {
                                    abc.append(abs[k]);
                                }
                                System.out.println((p+1)+". "+abc);
                            }
                            }
                            i++;
                        }
                        if (i<vocab.size())
                        {
                            in=vocab.get(i);
                        }
                        else
                            break;
                    }
                    i--;
                }
                else {
                    System.out.println("No repository exists with this name ");
                }
            }
        }
    }
}