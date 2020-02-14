package sg.com.ncs.brain.controller;

public class ConstraintsController {
	/*
	 * 
	 * @PostMapping("v1/import_constraint_types") public void create(@RequestBody
	 * Map<String, Object> req) {
	 * 
	 * 
	 * if(!req.containsKey("constraintTypes")) { throw new
	 * BadRequestException("No constraintTypes key provided in the body.",ErrorCodes
	 * .BAD_REQUEST); }
	 * 
	 * try{ saveJSONConstraintTypes(req.get("constraintTypes"));
	 * 
	 * 
	 * return res.status(result.httpStatusCode).send({success: result.result,
	 * message:result.message }); } catch(err){ return res.status(500).json({
	 * success: false, message: err}); }
	 * 
	 * 
	 * private void saveJSONConstraintTypes(cTypes){ let username="APISystem" let
	 * returnObject={}
	 * 
	 * try{ for(cType of cTypes){ let
	 * constraintTypeId=cType.hasOwnProperty("constraintTypeId")?cType[
	 * "constraintTypeId"]:null; let
	 * constraintTypeName=cType.hasOwnProperty("constraintTypeName")?cType[
	 * "constraintTypeName"]:null; let
	 * defaultDisplayName=cType.hasOwnProperty("defaultDisplayName")?cType[
	 * "defaultDisplayName"]:null;
	 * 
	 * // //insert type let constTypeObj= await
	 * insConstraintTypes(constraintTypeId,constraintTypeName,defaultDisplayName,
	 * username)
	 * 
	 * if(!constTypeObj.status){ returnObject["result"]=false
	 * returnObject["message"]="Constraint "+constraintTypeId+"error: "+constTypeObj
	 * .message returnObject["httpStatusCode"]=400 return returnObject }
	 * 
	 * let constType_id=constTypeObj.data
	 * 
	 * let constTypeParamObj= await
	 * insConstraintTypeParam(cType["parameterList"],constType_id,username)
	 * 
	 * if(!constTypeParamObj.status){ returnObject["result"]=false
	 * returnObject["message"]="Constraint "+constraintTypeId+"error: "
	 * +constTypeParamObj.message returnObject["httpStatusCode"]=400
	 * 
	 * return returnObject }
	 * 
	 * }
	 * 
	 * returnObject["result"]=true
	 * returnObject["message"]="Constraint Types Were Imported"
	 * returnObject["httpStatusCode"]=200
	 * 
	 * return returnObject
	 * 
	 * } catch(err){ returnObject["result"]=false returnObject["message"]=err
	 * returnObject["httpStatusCode"]=400
	 * 
	 * return returnObject } }
	 * 
	 * async function
	 * insConstraintTypes(constraintTypeId,constraintTypeName,defaultDisplayName,
	 * username){ try{ insConstType = await ConstraintType.findOrCreate({where:
	 * {constraintTypeId: constraintTypeId}, defaults: { constraintTypeName:
	 * constraintTypeName, defaultDisplayName: defaultDisplayName, created_by:
	 * username, updated_by: username } });
	 * 
	 * let consType_id=insConstType[0].get('id')
	 * 
	 * return { status: true, message: "ok", data:consType_id} } catch(err){ return
	 * { status: false, message:err } } }
	 * 
	 * async function
	 * insConstraintTypeParam(constrTypeParams,constraintTypeId,username){ try{ let
	 * paramObj for(param of constrTypeParams){ let
	 * parameterType=param.hasOwnProperty("parameterType")?param["parameterType"]:
	 * null; let
	 * parameterId=param.hasOwnProperty("parameterId")?param["parameterId"]:null;
	 * let
	 * parameterNum=param.hasOwnProperty("parameterNum")?param["parameterNum"]:null;
	 * let name=param.hasOwnProperty("name")?param["name"]:null;
	 * 
	 * let insParamObj= await ConstraintParam.findOrCreate({raw : true, where:
	 * {constraint_type_id:constraintTypeId, parameterId: parameterId}, defaults: {
	 * name:name, parameterNum:parameterNum, parameterType:parameterType,
	 * created_by: username, updated_by: username } }).then(async(insParam)=>{ let
	 * counter=1 for(pkey of Object.keys(param)){ let constParamId=insParam[0]['id']
	 * let value=param[pkey]
	 * 
	 * 
	 * if (value instanceof Array) { value=JSON.stringify(value) }
	 * 
	 * let parmStructure= await ConstraintParamStructure.findOrCreate({ where:
	 * {constraint_param_id:constParamId,key:pkey}, defaults: { seqNo:counter,
	 * value:value, created_by: username, updated_by: username }
	 * }).error(function(err){ return { status: false, message: err } })
	 * 
	 * counter++
	 * 
	 * }
	 * 
	 * }) }
	 * 
	 * return {status: true, message:"ok" } } catch(err){ return {status: false,
	 * message:err } } }
	 * 
	 * }
	 * 
	 * private void saveJSONConstraintTypes(Object object) { // TODO Auto-generated
	 * method stub
	 * 
	 * }
	 * 
	 */}
