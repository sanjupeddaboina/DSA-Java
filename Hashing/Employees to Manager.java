/* Employees to Manager:
Given a dictionary of employee:manager where they are represented by characters,
Print manager number_of employees_under_the_manager where managers sorted in lexical order
Number of employees also include indirect reports not only direct reports.
It may be assumed that an employee directly reports to only one manager.
In the above dictionary the root node/ceo is listed as reporting to himself.

Note: You are given a dictionary named emp containing employee:manager as key:value so you only need to complete the function and print output
*/


class Solution {

    public void EmpUnderManager(Map<String, String> employees){
        Map<String,ArrayList<String>> mngrMap = new TreeMap<>();
        String CEO = "";
        for(String emp : employees.keySet()){
            String mngr = employees.get(emp);
            if(mngr.equals(emp)){
                CEO += mngr;
                continue;
            }
            if(mngrMap.containsKey(mngr)){
                mngrMap.get(mngr).add(emp);
            }else{
                ArrayList<String> list = new ArrayList<>();
                list.add(emp);
                mngrMap.put(mngr,list);
            }
        }
        Map<String,Integer> empCount = new TreeMap<>();
        int CEOEmployees = ManagerToEmpCount(CEO,mngrMap,empCount);
        for(String e : empCount.keySet()){
            System.out.println(e +" "+empCount.get(e));
        }

	}
    public static int ManagerToEmpCount(String mgr,Map<String,ArrayList<String>> mngrMap,Map<String,Integer> empCount){
        List<String> directEmp = mngrMap.get(mgr);
        if(directEmp == null){
            empCount.put(mgr,0);
            return 0;
        }
        int inderectEmp = 0;
        for(String emp : directEmp){
            inderectEmp += ManagerToEmpCount(emp,mngrMap,empCount);
        }
        empCount.put(mgr,inderectEmp+directEmp.size());
        return inderectEmp+directEmp.size();
    }
}
