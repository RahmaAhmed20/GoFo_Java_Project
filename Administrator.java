
package com.mycompany.gofo;
/**
 * this is administrator class
 * @author Rahma Ahmed
 * @version 1.0
 * @since June 2021
 */
public class Administrator {

    /**
     * this function check availability
     * @param playground The value to set the playground field to
     * @param status The value to set the status field to
     * @return playground
     */
    public Playground checkAvailability(Playground playground , String status)
    {
      if (status.equalsIgnoreCase("suspend"))
      {
          playground.updateStatus(Status.Suspend);
      }
      else if (status.equalsIgnoreCase("Activate"))
      {
          playground.updateStatus(Status.Activate);
      }
      else
        {
            playground.updateStatus(Status.Not_Activate);
        }
      return playground ;
    }

    /**
     * this function to delete playground
     * @param playground The value to set the playground field to
     * @return playground
     */
    public Playground deletePlayground(Playground playground ) {
        playground.updateStatus(Status.deleted);
        return  playground ;

    }
}
