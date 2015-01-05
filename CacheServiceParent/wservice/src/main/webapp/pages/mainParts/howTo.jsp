<fieldset class="field shadow">
	<legend>How to create service</legend>
	<div class="row">
		<label>For new service we need only name. First of all application will check is 
				sent name used before. If not application will create service and return session.
				Every session contain id and name. Name should be equal as service name.</label>
	</div>
</fieldset>

<fieldset class="field shadow">
	<legend>How to get service session</legend>
	<div class="row">
		<label>Session is necessary for database. We can get session with name.
		First of all application will check is cache with sent name available. 
		If yes, application will return session.</label>
	</div>
</fieldset>


<fieldset class="field shadow">
	<legend>How to put values</legend>
	<div class="row">
		<label>We need session for putting values in cache. 
		We can first get session as describe before. On right side we can put number of fields.
		Every field have key and value. Empty keys are allowed but not recommended.</label>
	</div>
</fieldset>

<fieldset class="field shadow">
	<legend>How to get values</legend>
	<div class="row">
		<label>We need session for getting values form cache. 
		We can first get session as describe before. First we should set key and value which application
		should find. If we send empty key and value application will not return all rows. If we send non-empty key and value, application
		 will find all rows which contains specified field.</label>
	</div>
</fieldset>

<fieldset class="field shadow">
	<legend>How to close session</legend>
	<div class="row">
		<label>We can close session with action close session. Next session for this cache name should be different.</label>
	</div>
</fieldset>