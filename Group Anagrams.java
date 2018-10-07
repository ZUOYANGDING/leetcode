class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> re = new ArrayList<>();
        if (strs==null || strs.length<1){
            return re;
        }
        HashMap<String, List<String>> h = new HashMap<>();
        for (int i=0; i<strs.length; i++){
            String temp = strs[i];
            char[] c = temp.toCharArray();
            Arrays.sort(c);
            String tempKey = String.valueOf(c);
            if (!h.containsKey(tempKey)){
                ArrayList<String> a = new ArrayList<>();
                a.add(temp);
                h.put(tempKey, a);
            } else {
                h.get(tempKey).add(temp);
            }
        }
        Iterator<HashMap.Entry<String, List<String>>> it = h.entrySet().iterator();
        while(it.hasNext()){
            HashMap.Entry<String, List<String>> pair = it.next();
            re.add(pair.getValue());
        }
        return re;
    }
}