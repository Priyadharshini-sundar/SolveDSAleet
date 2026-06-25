class Solution {
    public List<Integer> getRow(int rowIndex)
    {
        List<Integer> li = new ArrayList<>();
        int n = rowIndex+1;
        long ans =1;
        li.add(1);
        for(int i=1;i<n;i++)
        {
            ans = ans*(n-i);
            ans = ans/i;
            li.add((int)(ans));
        }
        return li;
    }
}