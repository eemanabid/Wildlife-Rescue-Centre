# ENSF380FinalProject

Your client, Example Wildlife Rescue (EWR), needs a program which can be used to generate a daily list
of tasks for volunteers to complete in order to support the animals in residence. EWR specializes in
medium-sized animals and refers other cases to other centres. They have facilities to support coyotes,
foxes, porcupines, beavers and raccoons.

You are being asked to design an application which will calculate a schedule for an entire day. EWR
currently uses a database which is updated throughout the day by the staff vet to keep track of required
medical tasks. Each animal will have at least 1 medical task associated with it. Your application should
read from the same database to identify the tasks. EWR expects that Sara will run the program each
evening and, if necessary, contact the backup volunteer.

Feeding information is not included in the database. It is based on set times according to whether the
animal is nocturnal, diurnal, or crepuscular. The amount of time required for feeding depends on the
type of animal (e.g., coyotes always take 5 minutes per animal, with 10 minutes of preparation time for
any feeding activity). For orphaned animals, feeding is considered a medical task rather than a standard
task. Cage cleaning is another activity not included in the database. It can be done at any time of day,
and takes a consistent amount of time for each type of animal.

The program should create a file containing the schedule. If Sara needs to call the backup volunteer, the
program should inform her and it should not exit until she has confirmed that she has called the
volunteer for the necessary time(s). If it is not possible to create a schedule, the program should report
the problem so that Sara can contact the staff vet to request a change of requirements. As the staff vet
may not be on site, Sara needs to be able to modify the start hour of one or more of the treatments
based on the advice she receives. The new schedule should be created after the database is updated.
