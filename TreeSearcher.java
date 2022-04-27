class TreeSearcher implements HashTreeTraverser
{
    Object target;
    HashTree result;
 
    public TreeSearcher(Object t)
    {
        target = t;
    }
 
    public HashTree getResult()
    {
        return result;
    }
    public void addNode(Object node, HashTree subTree)
    {
        result = subTree.getTree(target);
        if (result != null)
        {
            throw new RuntimeException("found"); 
        }
    }
 
    @Override
    public void subtractNode()
    {
    }
 
    @Override
    public void processPath()
    {
    }
}