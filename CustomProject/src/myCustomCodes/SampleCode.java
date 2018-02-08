package myCustomCodes;

import com.cognizant.commands.General;
import com.cognizant.core.CommandControl;

import com.cognizant.support.Status;
import com.cognizant.support.methodInf.SpritzAction;
import com.cognizant.support.methodInf.ObjectType;
import com.cognizant.support.methodInf.InputType;

public class SampleCode extends General {

	public SampleCode(CommandControl cc) {
		super(cc);
	}

	/**
	 * Sample Validation Code
	 */
	@SpritzAction(object = ObjectType.SELENIUM, desc = "Description of the method", input = InputType.YES)
	public void CheckDiscount() {
		String input = Element.getAttribute("value");
		if (input.equals(Data)) {
			Report.updateTestLog(Action, Description, Status.PASS);
		} else {
			Report.updateTestLog(Action, Description, Status.FAIL);
		}
	}

	/**
	 * Sample Code for fetching the data from the global data sheet in the
	 * Input format -- #globalID:ColumnName Input format Example --
	 * #gd1:Username
	 */
	@SpritzAction(object = ObjectType.BROWSER, desc = "Print the global data", input = InputType.YES)
	public void fetchGlobalData() {
		String[] User_input = Data.split(":");
		String key = User_input[0];
		String column = User_input[1];
		String val = userData.getGlobalData(key, column);
		Report.updateTestLog("printGlobalData ", "The global data passed is " + val, Status.DONE);
	}

}
