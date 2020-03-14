package zad3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.function.Predicate;


public class ProgLang
{
    Map<String, ArrayList<String>> langmap;
    Map<String, ArrayList<String>> progmap;

    public ProgLang(String path)
    {
        langmap = new LinkedHashMap<>();
        progmap = new LinkedHashMap<>();
        ArrayList<String> filelist = new ArrayList<>();
        ArrayList<String> tmplist = null;
        ArrayList<String> progtmp = new ArrayList<>();
        String[] tabtmp = null;
        try
        {
            Scanner scan = new Scanner(new File(path));
            while(scan.hasNext())
            {
                filelist.add(scan.nextLine());
            }
            scan.close();
        }
        catch (FileNotFoundException e) {}
        for(int i = 0; i < filelist.size(); i++)
        {
            tmplist = new ArrayList<>();
            tabtmp = filelist.get(i).split("\t");
            for(int j = 1; j < tabtmp.length; j++)
                if(!tmplist.contains(tabtmp[j]))
                    tmplist.add(tabtmp[j]);
            langmap.put(tabtmp[0], tmplist);
            for(int j = 1; j < tabtmp.length; j++)
                if(!progtmp.contains(tabtmp[j]))
                    progtmp.add(tabtmp[j]);
        }
        for(int i = 0; i < progtmp.size(); i++)
        {
            tmplist = new ArrayList<>();
            for(int j = 0; j < filelist.size(); j++)
            {
                tabtmp = filelist.get(j).split("\t");
                for(int z = 1; z < tabtmp.length; z++)
                    if(tabtmp[z].equals(progtmp.get(i)))
                        if(!tmplist.contains(tabtmp[0]))
                            tmplist.add(tabtmp[0]);
            }
            progmap.put(progtmp.get(i), tmplist);
        }
    }

    public <K, V> Map <K, V> sorted(Map <K, V> map, Comparator <Map.Entry <K, V>> comp)
    {
        List<Map.Entry <K, V>> list = new LinkedList <>(map.entrySet());
        Collections.sort(list, comp);
        Map <K, V> result = new LinkedHashMap <>();
        for (Map.Entry <K, V> entry : list)
        {
            result.put(entry.getKey(),entry.getValue());
        }
        return result;
    }

    public <K, V> Map <K, V> filtered(Map <K, V> map, Predicate <Map.Entry <K, V>> pred) {

        Map <K, V> result = new LinkedHashMap <>();
        Set<Map.Entry <K, V>> set = map.entrySet();
        Iterator<Map.Entry<K, V>> i = set.iterator();
        while(i.hasNext())
        {
            Map.Entry<K, V> me = i.next();
            if(pred.test(me))
                result.put(me.getKey(), me.getValue());
        }
        return result;
    }

    public Map <String, ArrayList<String>> getLangsMap() {
        return langmap;
    }

    public Map <String, ArrayList<String>> getProgsMap() {
        return progmap;
    }

    public Map<String, ArrayList<String>> getLangsMapSortedByNumOfProgs() {

        return sorted(langmap, (o1, o2) -> {
            if (( o1.getValue()).size() > (o2.getValue()).size())
                return -1;
            if ((o1.getValue()).size() < ( o2.getValue()).size())
                return 1;
            if ((o1.getValue()).size() == (o2.getValue()).size())
            {
                if((o2.getKey()).compareTo(o1.getKey()) > 0)
                    return -1;
                if((o2.getKey()).compareTo(o1.getKey()) < 0)
                    return 1;
                else
                    return 0;
            }
            else
                return 0;
        });
    }

    public Map <String, ArrayList<String>> getProgsMapSortedByNumOfLangs() {

        return sorted(progmap, (o1, o2) -> {
            if ((o1.getValue()).size() > (o2.getValue()).size())
                return -1;
            if ((o1.getValue()).size() < (o2.getValue()).size())
                return 1;
            if ((o1.getValue()).size() == (o2.getValue()).size())
            {
                if((o2.getKey()).compareTo(o1.getKey()) > 0)
                    return -1;
                if((o2.getKey()).compareTo(o1.getKey()) < 0)
                    return 1;
                else
                    return 0;
            }
            else
                return 0;
        });
    }

    public Map <String, ArrayList<String>> getProgsMapForNumOfLangsGreaterThan(int n) {
        return filtered(progmap, t -> (((t.getValue()).size())) > n);
    }
}